package com.badlogic.masaki.firebasesample.presentation.dynamiclink.mapper

import com.badlogic.masaki.firebasesample.domain.model.DeepLink

interface Mapper<T> {
    fun toDeepLink(source: T, callback: Callback)

    interface Callback {
        fun onSuccess(deepLink: DeepLink)
        fun onError(e: Throwable)
    }
}