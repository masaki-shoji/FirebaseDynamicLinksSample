package com.badlogic.masaki.firebasesample.presentation.license

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.badlogic.masaki.firebasesample.R
import com.badlogic.masaki.firebasesample.databinding.ActivityLicenseBinding

class LicenseListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityLicenseBinding>(this, R.layout.activity_license)
    }
}