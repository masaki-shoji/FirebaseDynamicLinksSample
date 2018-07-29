package com.badlogic.masaki.firebasesample.di;

import com.badlogic.masaki.firebasesample.util.*;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.Executor;
import javax.inject.Named;
import javax.inject.Singleton;

@Module
public abstract class ExecutorModule {

    @Provides @Named("mainThread")
    public static Executor provideMainHandler() {
        return new MainThreadExecutor();
    }

    @Provides @Singleton @Named("networkIO")
    public static Executor provideNetworkExecutor() {
        return new NetworkIOExecutor();
    }

    @Provides @Singleton @Named("diskIO")
    public static Executor provideDiskIOExecutor() {
        return new DiskIOExecutor();
    }

    @Provides @Singleton @Named("computation")
    public static Executor provideComputationExecutor() {
        return new ComputationExecutor();
    }

    @Provides @Singleton
    public static ApplicationExecutor provideAppExecutors(@Named("mainThread")Executor mainThread,
                            @Named("networkIO") Executor networkIO,
                            @Named("diskIO") Executor diskIO,
                            @Named("computation") Executor computation) {
        return new AppExecutors(mainThread, networkIO, diskIO, computation);
    }
}
