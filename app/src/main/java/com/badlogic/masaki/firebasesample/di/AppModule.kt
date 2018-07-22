package com.badlogic.masaki.firebasesample.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class AppModule {
    @Singleton @Binds
    abstract fun provideContext(application: Application): Context
}