package com.badlogic.masaki.firebasesample.presentation.splash

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.app.AppCompatActivity
import com.badlogic.masaki.firebasesample.R
import com.badlogic.masaki.firebasesample.databinding.ActivitySplashBinding
import com.badlogic.masaki.firebasesample.presentation.top.TopActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        DataBindingUtil.setContentView<ActivitySplashBinding>(this, R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            val i = Intent(this, TopActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                    or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    or Intent.FLAG_ACTIVITY_NO_ANIMATION)
            overridePendingTransition(0, 0)
            startActivity(i)
            finish()
        }, 1000)
    }
}
