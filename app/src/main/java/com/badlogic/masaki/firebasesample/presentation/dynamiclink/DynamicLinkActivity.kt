package com.badlogic.masaki.firebasesample.presentation.dynamiclink

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.badlogic.masaki.firebasesample.R
import com.badlogic.masaki.firebasesample.databinding.ActivityDynamicLinkBinding
import dagger.Lazy
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class DynamicLinkActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var mFragment: Lazy<DynamicLinkFragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityDynamicLinkBinding>(this, R.layout.activity_dynamic_link)

        val fragment = supportFragmentManager.findFragmentById(R.id.content)

        if (fragment == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.content, mFragment.get())
                    .commit()
        }
    }
}
