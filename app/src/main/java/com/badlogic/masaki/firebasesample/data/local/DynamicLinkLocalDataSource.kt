package com.badlogic.masaki.firebasesample.data.local

import android.content.Context
import com.badlogic.masaki.firebasesample.data.local.prefs.Prefs
import com.badlogic.masaki.firebasesample.data.repository.DynamicLinkDataSource
import com.badlogic.masaki.firebasesample.di.annotation.Local
import javax.inject.Inject
import javax.inject.Singleton

@Singleton @Local
class DynamicLinkLocalDataSource
    @Inject constructor(context: Context) : DynamicLinkDataSource {

    private val mContext: Context = context

    override fun clearPendingDynamicLinkData() = Prefs.clearPendingDynamicLinkData(mContext)

    override fun getDestination() = Prefs.getDestination(mContext)

    override fun saveDestination(destination: String?) = Prefs.saveDestination(mContext, destination)
}