package com.badlogic.masaki.firebasesample.presentation.dynamiclink

import android.support.annotation.Nullable
import com.badlogic.masaki.firebasesample.di.annotation.ActivityScoped
import com.badlogic.masaki.firebasesample.domain.DynamicLinkRoute
import com.badlogic.masaki.firebasesample.presentation.dynamiclink.item.DynamicLinkItem
import com.badlogic.masaki.firebasesample.domain.model.DeepLink
import com.badlogic.masaki.firebasesample.domain.usecase.dynamiclink.DynamicLinkUseCase
import com.badlogic.masaki.firebasesample.presentation.dynamiclink.mapper.Mapper
import com.badlogic.masaki.firebasesample.util.AppExecutors
import com.badlogic.masaki.firebasesample.util.ApplicationExecutor
import javax.inject.Inject

@ActivityScoped
class DynamicLinkPresenter
    @Inject constructor(dynamicLinkItem: DynamicLinkItem,
                        mapper: Mapper<DynamicLinkItem>,
                        useCase: DynamicLinkUseCase,
                        appExecutors: ApplicationExecutor) : DynamicLinkContract.Presenter {

    @Nullable
    private var view: DynamicLinkContract.View? = null

    private val mDynamicLinkItem: DynamicLinkItem = dynamicLinkItem

    private val mMapper: Mapper<DynamicLinkItem> = mapper

    private val mUseCase: DynamicLinkUseCase = useCase

    private val mAppExecutors: ApplicationExecutor = appExecutors

    override fun handleDynamicLinkItem() {
        mMapper.toDeepLink(mDynamicLinkItem, object: Mapper.Callback {
            override fun onSuccess(deepLink: DeepLink) {
                this@DynamicLinkPresenter.handleDeepLink(deepLink)
            }

            override fun onError(e: Throwable) {
                view?.let {
                    if (it.isActive()) {
                        it.onDynamicLinkHandlingErrorOccurred(e)
                    }
                }
            }
        })
    }

    override fun handleDeepLink(deepLink: DeepLink) {
        //delegates the task to a usecase.
        mAppExecutors.diskIO().execute {
            mUseCase.handleDeepLink(deepLink,
                    object: DynamicLinkUseCase.Callback {
                        override fun onSuccess(route: DynamicLinkRoute) {
                            onDeepLinkHandled()
                        }

                        override fun onError(e: Throwable) {
                            onDeepLinkHandlingError(e)
                        }
                    })
        }
    }

    private fun onDeepLinkHandled() {
        mAppExecutors.mainThread().execute {
            view?.let {
                if (it.isActive()) {
                    it.onDeepLinkHandled()
                }
            }
        }
    }

    private fun onDeepLinkHandlingError(e: Throwable) {
        mAppExecutors.mainThread().execute {
            view?.let {
                if (it.isActive()) {
                    it.onDynamicLinkHandlingErrorOccurred(e)
                }
            }
        }

    }

    override fun setView(view: DynamicLinkContract.View): DynamicLinkContract.Presenter {
        this.view = view
        return this
    }

    override fun dropView() {
        view = null
    }

}