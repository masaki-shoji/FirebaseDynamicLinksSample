package com.badlogic.masaki.firebasesample.di

import android.content.Context
import com.badlogic.masaki.firebasesample.data.local.DynamicLinkLocalDataSource
import com.badlogic.masaki.firebasesample.data.repository.DynamicLinkDataSource
import com.badlogic.masaki.firebasesample.data.repository.DynamicLinkRepository
import com.badlogic.masaki.firebasesample.di.annotation.Local
import com.badlogic.masaki.firebasesample.di.annotation.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class DatabaseModule {
    @Singleton @Provides @Local
    fun provideDynamicLinkLocalDataSource(context: Context): DynamicLinkDataSource
            = DynamicLinkLocalDataSource(context)

    @Singleton @Provides @Repository
    fun provideDynamicLinkRepository(@Local localDataSource: DynamicLinkDataSource): DynamicLinkDataSource {
        return DynamicLinkRepository(localDataSource)
    }
}