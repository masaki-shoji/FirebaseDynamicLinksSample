package com.badlogic.masaki.firebasesample.domain.usecase.top

import com.badlogic.masaki.firebasesample.domain.DynamicLinkRoute

interface TopUseCase {

    fun handleDeepLinkIfNeeded(callback: Callback)
    fun clearPendingDynamicLinkData()

    interface Callback {
        fun onResponse(route: DynamicLinkRoute)
        fun onRouteNotFound()
        fun onError(e: Throwable)
    }
}