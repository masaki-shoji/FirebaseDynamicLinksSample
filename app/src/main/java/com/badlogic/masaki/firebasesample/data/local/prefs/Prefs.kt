package com.badlogic.masaki.firebasesample.data.local.prefs

import android.content.Context
import android.content.SharedPreferences

object Prefs {

    private const val PREFS_NAME: String = "prefs"

    private const val KEY_DESTINATION = "destination"

    private fun getPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    @JvmStatic @Throws(ClassCastException::class)
    fun clearPendingDynamicLinkData(context: Context) {
        getPrefs(context).edit().putString(KEY_DESTINATION, null).apply()
    }

    @JvmStatic @Throws(ClassCastException::class)
    fun getDestination(context: Context): String? {
        return getPrefs(context).getString(KEY_DESTINATION, null)
    }

    @JvmStatic @Throws(ClassCastException::class)
    fun saveDestination(context: Context, destination: String?) {
        getPrefs(context).edit().putString(KEY_DESTINATION, destination).apply()
    }
}