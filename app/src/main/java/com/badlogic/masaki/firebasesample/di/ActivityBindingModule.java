package com.badlogic.masaki.firebasesample.di;

import com.badlogic.masaki.firebasesample.di.activityscope.DynamicLinkActivityModule;
import com.badlogic.masaki.firebasesample.di.annotation.ActivityScoped;
import com.badlogic.masaki.firebasesample.di.activityscope.TopActivityModule;
import com.badlogic.masaki.firebasesample.presentation.dynamiclink.DynamicLinkActivity;
import com.badlogic.masaki.firebasesample.presentation.top.TopActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = TopActivityModule.class)
    TopActivity topActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = DynamicLinkActivityModule.class)
    DynamicLinkActivity dynamicLinkActivity();
}