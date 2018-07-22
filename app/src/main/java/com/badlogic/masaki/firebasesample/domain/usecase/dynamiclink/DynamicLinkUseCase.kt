package com.badlogic.masaki.firebasesample.domain.usecase.dynamiclink

import com.badlogic.masaki.firebasesample.domain.DynamicLinkRoute
import com.badlogic.masaki.firebasesample.domain.model.DeepLink

interface DynamicLinkUseCase {

    interface Callback {
        fun onSuccess(route: DynamicLinkRoute)
        fun onError(e: Throwable)
    }

    fun handleDeepLink(deepLink: DeepLink, callback: Callback)
}
