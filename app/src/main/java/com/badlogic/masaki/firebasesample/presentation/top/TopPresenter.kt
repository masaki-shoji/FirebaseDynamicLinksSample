package com.badlogic.masaki.firebasesample.presentation.top

import android.support.annotation.Nullable
import com.badlogic.masaki.firebasesample.di.annotation.ActivityScoped
import com.badlogic.masaki.firebasesample.domain.DynamicLinkRoute
import com.badlogic.masaki.firebasesample.domain.usecase.top.TopUseCase
import com.badlogic.masaki.firebasesample.util.AppExecutors
import javax.inject.Inject

@ActivityScoped
class TopPresenter @Inject constructor(useCase: TopUseCase, appExecutors: AppExecutors)
    : TopContract.Presenter {

    @Nullable
    private var mView: TopContract.View? = null

    private val mUseCase: TopUseCase = useCase

    private val mAppExecutors: AppExecutors = appExecutors

    override fun setView(view: TopContract.View): TopContract.Presenter {
        mView = view
        return this
    }

    override fun dropView() {
        mView = null
    }

    override fun handleDeepLinkIfNeeded() {
        mAppExecutors.diskIO().execute {
            mUseCase.handleDeepLinkIfNeeded(object: TopUseCase.Callback {
                override fun onResponse(route: DynamicLinkRoute) {
                    if (isViewActive()) {
                        mAppExecutors.mainThread().execute {
                            mView?.navigate(route)
                        }
                    }
                }

                override fun onRouteNotFound() {
                    //does nothing at the moment.
                }

                override fun onError(e: Throwable) {
                    if (isViewActive()) {
                        showError(e)
                    }
                }
            })
        }
    }

    override fun clearPendingDynamicLinkData() {
        mUseCase.clearPendingDynamicLinkData()
    }

    private fun showError(e: Throwable) {
        mAppExecutors.mainThread().execute {
            mView?.showError(e)
        }
    }

    private fun isViewActive(): Boolean {
        return mView != null && mView?.isActive()!!
    }
}
