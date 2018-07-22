package com.badlogic.masaki.firebasesample.presentation.dynamiclink

import com.badlogic.masaki.firebasesample.domain.model.DeepLink

interface DynamicLinkContract {

    interface View {
        fun onDeepLinkHandled()
        fun onDynamicLinkHandlingErrorOccurred(e: Throwable)
        fun isActive(): Boolean
    }

    interface Presenter {
        fun handleDynamicLinkItem()
        fun handleDeepLink(deepLink: DeepLink)
        fun setView(view: View): Presenter
        fun dropView()
    }
}