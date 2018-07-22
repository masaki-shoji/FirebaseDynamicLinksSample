package com.badlogic.masaki.firebasesample.presentation.top

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.badlogic.masaki.firebasesample.common.GITHUB_URL
import com.badlogic.masaki.firebasesample.databinding.FragmentTopBinding
import com.badlogic.masaki.firebasesample.domain.DynamicLinkRoute
import com.badlogic.masaki.firebasesample.presentation.common.AppNavigator
import com.badlogic.masaki.firebasesample.presentation.license.LicenseListActivity
import com.badlogic.masaki.firebasesample.presentation.webview.WebViewActivity
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class TopFragment : DaggerFragment(), TopContract.View {

    private lateinit var mBinding: FragmentTopBinding

    @Inject
    lateinit var mPresenter: TopContract.Presenter

    @Inject
    lateinit var mNavigator: AppNavigator

    companion object {
        fun newInstance(): TopFragment = TopFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mPresenter.setView(this).handleDeepLinkIfNeeded()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = FragmentTopBinding.inflate(inflater, container, false)

        mBinding.apply {
            buttonToOss.setOnClickListener {
                mNavigator.navigateToLicense()
            }
            buttonToWebView.setOnClickListener {
                mNavigator.navigateToWebView()
            }
            buttonToGithub.setOnClickListener {
                mNavigator.navigateToGithub()
            }
        }

        return mBinding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.dropView()
    }

    override fun isActive(): Boolean {
        return isAdded
    }

    override fun navigate(route: DynamicLinkRoute) {
        try {
            mNavigator.navigateByDynamicLinkRoute(route)
        } finally {
            mPresenter.clearPendingDynamicLinkData()
        }
    }

    override fun showError(e: Throwable) {
        AlertDialog.Builder(activity!!)
                .setMessage(e.message)
                .create().show()
    }
}