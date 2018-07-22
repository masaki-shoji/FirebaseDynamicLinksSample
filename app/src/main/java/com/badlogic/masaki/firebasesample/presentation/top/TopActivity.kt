package com.badlogic.masaki.firebasesample.presentation.top

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.badlogic.masaki.firebasesample.R
import com.badlogic.masaki.firebasesample.databinding.ActivityTopBinding
import dagger.android.support.DaggerAppCompatActivity

class TopActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityTopBinding>(this, R.layout.activity_top)

        val f = supportFragmentManager.findFragmentById(R.id.content)
        if (f == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.content, TopFragment.newInstance())
                    .commit()
        }
    }
}