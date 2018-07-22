package com.badlogic.masaki.firebasesample.domain.usecase.top

import com.badlogic.masaki.firebasesample.data.repository.DynamicLinkDataSource
import com.badlogic.masaki.firebasesample.di.annotation.ActivityScoped
import com.badlogic.masaki.firebasesample.di.annotation.Repository
import com.badlogic.masaki.firebasesample.domain.DynamicLinkRoute
import javax.inject.Inject

@ActivityScoped
class TopUseCaseImpl : TopUseCase {

    private val mRepository: DynamicLinkDataSource

    @Inject constructor(@Repository repository: DynamicLinkDataSource) {
        mRepository = repository
    }

    override fun handleDeepLinkIfNeeded(callback: TopUseCase.Callback) {
        try {
            val destination = mRepository.getDestination()
            if (destination == null) {
                callback.onRouteNotFound()
                return
            }

            val route = DynamicLinkRoute.getEnum(destination)
            if (route == null) {
                callback.onRouteNotFound()
                return
            }

            callback.onResponse(route)
        } catch (e: ClassCastException) {
            callback.onError(e)
        }
    }

    override fun clearPendingDynamicLinkData() {
        mRepository.clearPendingDynamicLinkData()
    }
}