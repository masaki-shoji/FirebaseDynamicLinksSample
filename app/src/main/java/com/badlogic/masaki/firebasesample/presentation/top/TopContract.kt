package com.badlogic.masaki.firebasesample.presentation.top

import com.badlogic.masaki.firebasesample.domain.DynamicLinkRoute

interface TopContract {

    interface View {
        fun isActive(): Boolean
        fun navigate(route: DynamicLinkRoute)
        fun showError(e: Throwable)
    }

    interface Presenter {
        fun setView(view: View): Presenter
        fun dropView()
        fun handleDeepLinkIfNeeded()
        fun clearPendingDynamicLinkData()
    }
}