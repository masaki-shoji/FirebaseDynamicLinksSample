package com.badlogic.masaki.firebasesample.presentation.meaningless

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.badlogic.masaki.firebasesample.R
import com.badlogic.masaki.firebasesample.databinding.ActivityMeaninglessBinding

class MeaninglessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMeaninglessBinding>(this, R.layout.activity_meaningless)
    }
}