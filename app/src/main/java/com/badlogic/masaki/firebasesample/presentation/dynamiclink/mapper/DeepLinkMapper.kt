package com.badlogic.masaki.firebasesample.presentation.dynamiclink.mapper

import com.badlogic.masaki.firebasesample.di.annotation.ActivityScoped
import com.badlogic.masaki.firebasesample.presentation.dynamiclink.item.DynamicLinkItem
import com.badlogic.masaki.firebasesample.domain.model.DeepLink
import javax.inject.Inject

@ActivityScoped
class DeepLinkMapper
    @Inject constructor(): Mapper<DynamicLinkItem> {

    override fun toDeepLink(source: DynamicLinkItem, callback: Mapper.Callback) {
        source.deepLinkTask.addOnSuccessListener {
            val deepLink = DeepLink(it.link)
            callback.onSuccess(deepLink)
        }.addOnFailureListener {
            callback.onError(it)
        }
    }
}