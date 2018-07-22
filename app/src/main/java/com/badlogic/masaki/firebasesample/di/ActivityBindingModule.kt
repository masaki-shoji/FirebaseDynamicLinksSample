package com.badlogic.masaki.firebasesample.di

import com.badlogic.masaki.firebasesample.di.activityscope.DynamicLinkActivityModule
import com.badlogic.masaki.firebasesample.di.annotation.ActivityScoped
import com.badlogic.masaki.firebasesample.di.activityscope.TopActivityModule
import com.badlogic.masaki.firebasesample.presentation.dynamiclink.DynamicLinkActivity
import com.badlogic.masaki.firebasesample.presentation.top.TopActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [TopActivityModule::class])
    fun topActivity(): TopActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [DynamicLinkActivityModule::class])
    fun dynamicLinkActivity(): DynamicLinkActivity
}