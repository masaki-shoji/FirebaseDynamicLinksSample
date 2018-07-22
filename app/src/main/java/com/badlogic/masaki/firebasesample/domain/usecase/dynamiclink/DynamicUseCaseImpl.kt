package com.badlogic.masaki.firebasesample.domain.usecase.dynamiclink

import com.badlogic.masaki.firebasesample.data.repository.DynamicLinkDataSource
import com.badlogic.masaki.firebasesample.di.annotation.ActivityScoped
import com.badlogic.masaki.firebasesample.domain.DynamicLinkRoute
import com.badlogic.masaki.firebasesample.domain.model.DeepLink
import javax.inject.Inject

@ActivityScoped
class DynamicUseCaseImpl
    @Inject constructor(repository: DynamicLinkDataSource) : DynamicLinkUseCase {

    private val mRepository: DynamicLinkDataSource = repository

    override fun handleDeepLink(deepLink: DeepLink, callback: DynamicLinkUseCase.Callback) {
        val path = deepLink.path
        try {
            path?.let {
                val route: DynamicLinkRoute? = DynamicLinkRoute.getEnum(it)
                if (route == null) {
                    mRepository.saveDestination(null)
                    callback.onError(RuntimeException("the path of DeepLink does not belong to any value of DynamicLinkRoute"))
                } else {
                    mRepository.saveDestination(path)
                    callback.onSuccess(route)
                }
            }
        } catch (e: Exception) {
            mRepository.saveDestination(null)
            callback.onError(e)
        }
    }
}
