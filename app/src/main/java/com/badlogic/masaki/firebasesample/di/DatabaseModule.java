package com.badlogic.masaki.firebasesample.di;

import android.content.Context;
import com.badlogic.masaki.firebasesample.data.local.DynamicLinkLocalDataSource;
import com.badlogic.masaki.firebasesample.data.repository.DynamicLinkDataSource;
import com.badlogic.masaki.firebasesample.data.repository.DynamicLinkRepository;
import com.badlogic.masaki.firebasesample.di.annotation.Local;
import com.badlogic.masaki.firebasesample.di.annotation.Repository;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public abstract class DatabaseModule {
    @Singleton @Provides @Local
    public static DynamicLinkDataSource provideDynamicLinkLocalDataSource(Context context) {
        return new DynamicLinkLocalDataSource(context);
    }

    @Singleton @Provides @Repository
    public static DynamicLinkDataSource provideDynamicLinkRepository
            (@Local DynamicLinkDataSource localDataSource) {
        return new DynamicLinkRepository(localDataSource);
    }
}