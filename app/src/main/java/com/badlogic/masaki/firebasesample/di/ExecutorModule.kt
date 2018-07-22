package com.badlogic.masaki.firebasesample.di

import com.badlogic.masaki.firebasesample.util.*
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import javax.inject.Named
import javax.inject.Singleton

@Module
open class ExecutorModule {

    @Provides @Named("mainThread")
    fun provideMainHandler(): Executor = MainThreadExecutor()

    @Provides @Singleton @Named("networkIO")
    fun provideNetworkExecutor(): Executor = NetworkIOExecutor()

    @Provides @Singleton @Named("diskIO")
    fun provideDiskIOExecutor(): Executor = DiskIOExecutor()

    @Provides @Singleton @Named("computation")
    fun provideComputationExecutor(): Executor = ComputationExecutor()
}
