package com.badlogic.masaki.firebasesample.data.repository

import com.badlogic.masaki.firebasesample.di.annotation.Local
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DynamicLinkRepository
    @Inject constructor(@Local localDataSource: DynamicLinkDataSource) : DynamicLinkDataSource {

    private val mLocalDataSource: DynamicLinkDataSource = localDataSource

    override fun clearPendingDynamicLinkData() {
        mLocalDataSource.clearPendingDynamicLinkData()
    }

    override fun getDestination(): String? {
        return mLocalDataSource.getDestination()
    }

    override fun saveDestination(destination: String?) {
        mLocalDataSource.saveDestination(destination)
    }
}
