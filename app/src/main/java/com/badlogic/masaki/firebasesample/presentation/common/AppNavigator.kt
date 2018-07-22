package com.badlogic.masaki.firebasesample.presentation.common

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import com.badlogic.masaki.firebasesample.common.GITHUB_URL
import com.badlogic.masaki.firebasesample.domain.DynamicLinkRoute
import com.badlogic.masaki.firebasesample.presentation.license.LicenseListActivity
import com.badlogic.masaki.firebasesample.presentation.meaningless.MeaninglessActivity
import com.badlogic.masaki.firebasesample.presentation.top.TopActivity
import com.badlogic.masaki.firebasesample.presentation.webview.WebViewActivity
import javax.inject.Inject

class AppNavigator
    @Inject constructor(private val mActivity: AppCompatActivity) {

    fun navigateByDynamicLinkRoute(route: DynamicLinkRoute) {
        when(route) {
            DynamicLinkRoute.TOP -> {
                return
            }

            DynamicLinkRoute.OSS -> {
                navigateToLicense()
            }

            DynamicLinkRoute.WEB_VIEW -> {
                navigateToWebView()
            }

            DynamicLinkRoute.MEANINGLESS -> {
                navigateToMeaningless()
            }

            DynamicLinkRoute.DYNAMIC -> {
                return
            }
        }
    }

    fun navigateToTop() {
        mActivity.startActivity(Intent(mActivity, TopActivity::class.java))
    }

    fun navigateToLicense() {
        mActivity.startActivity(Intent(mActivity, LicenseListActivity::class.java))
    }

    fun navigateToWebView() {
        mActivity.startActivity(Intent(mActivity, WebViewActivity::class.java))
    }

    fun navigateToMeaningless() {
        mActivity.startActivity(Intent(mActivity, MeaninglessActivity::class.java))
    }

    fun navigateToGithub() {
        mActivity.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(GITHUB_URL)))
    }
}
