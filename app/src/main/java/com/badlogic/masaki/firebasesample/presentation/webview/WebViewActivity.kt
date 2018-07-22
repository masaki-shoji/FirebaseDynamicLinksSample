package com.badlogic.masaki.firebasesample.presentation.webview

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.badlogic.masaki.firebasesample.R
import com.badlogic.masaki.firebasesample.databinding.ActivityWebviewBinding

class WebViewActivity : AppCompatActivity() {

    private val mBinding: ActivityWebviewBinding by lazy {
        DataBindingUtil.setContentView<ActivityWebviewBinding>(this, R.layout.activity_webview)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding.webview.loadUrl("file:///android_asset/main.html")
    }
}