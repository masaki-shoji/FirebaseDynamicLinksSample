package com.badlogic.masaki.firebasesample.data.repository

interface DynamicLinkDataSource {
    fun clearPendingDynamicLinkData()
    fun getDestination(): String?
    fun saveDestination(destination: String?)
}