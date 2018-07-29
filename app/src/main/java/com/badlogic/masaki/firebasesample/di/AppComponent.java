package com.badlogic.masaki.firebasesample.di;

import android.app.Application;
import com.badlogic.masaki.firebasesample.App;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import javax.inject.Singleton;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBindingModule.class,
        AppModule.class,
        ExecutorModule.class,
        DatabaseModule.class
        })
public interface AppComponent extends AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance Builder application(Application application);
        AppComponent build();
    }
}