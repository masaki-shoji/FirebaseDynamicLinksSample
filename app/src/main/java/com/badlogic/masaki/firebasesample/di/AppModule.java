package com.badlogic.masaki.firebasesample.di;

import android.app.Application;
import android.content.Context;
import dagger.Binds;
import dagger.Module;
import javax.inject.Singleton;

@Module
public abstract class AppModule {
    @Singleton @Binds
    public abstract Context provideContext(Application application);
}