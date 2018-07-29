package com.badlogic.masaki.firebasesample.di.activityscope;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.badlogic.masaki.firebasesample.data.repository.DynamicLinkDataSource;
import com.badlogic.masaki.firebasesample.di.annotation.ActivityScoped;
import com.badlogic.masaki.firebasesample.di.annotation.FragmentScoped;
import com.badlogic.masaki.firebasesample.di.annotation.Repository;
import com.badlogic.masaki.firebasesample.domain.usecase.dynamiclink.DynamicLinkUseCase;
import com.badlogic.masaki.firebasesample.domain.usecase.dynamiclink.DynamicUseCaseImpl;
import com.badlogic.masaki.firebasesample.presentation.dynamiclink.item.DynamicLinkItem;
import com.badlogic.masaki.firebasesample.presentation.dynamiclink.DynamicLinkActivity;
import com.badlogic.masaki.firebasesample.presentation.dynamiclink.DynamicLinkContract;
import com.badlogic.masaki.firebasesample.presentation.dynamiclink.DynamicLinkFragment;
import com.badlogic.masaki.firebasesample.presentation.dynamiclink.DynamicLinkPresenter;
import com.badlogic.masaki.firebasesample.presentation.dynamiclink.mapper.DeepLinkMapper;
import com.badlogic.masaki.firebasesample.presentation.dynamiclink.mapper.Mapper;
import com.google.android.gms.tasks.Task;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class DynamicLinkActivityModule {

    @Binds @ActivityScoped
    abstract AppCompatActivity provideDynamicLinkActivity(DynamicLinkActivity activity);

    @Provides @ActivityScoped
    static Intent provideInent(AppCompatActivity activity) {
        return activity.getIntent();
    }

    @Provides @ActivityScoped
    static FirebaseDynamicLinks provideFirebaseDynamicLinks() {
        return FirebaseDynamicLinks.getInstance();
    }

    @Provides
    static Task<PendingDynamicLinkData> provideTask(FirebaseDynamicLinks firebaseDynamicLinks,
                             Intent intent) {
        return firebaseDynamicLinks.getDynamicLink(intent);
    }

    @Provides
    static DynamicLinkItem provideDynamicLinkItem(Task<PendingDynamicLinkData> task) {
        return new DynamicLinkItem(task);
    }

    @Binds @ActivityScoped
    abstract Mapper<DynamicLinkItem> provideDynamicLinkMapper(DeepLinkMapper mapper);

    @Binds @ActivityScoped
    abstract DynamicLinkContract.Presenter provideDynamicLinkPresenter(DynamicLinkPresenter presenter);

    @Provides @ActivityScoped
    static DynamicLinkUseCase provideDynamicLinkUseCase(@Repository DynamicLinkDataSource repository) {
        return new DynamicUseCaseImpl(repository);
    }

    @FragmentScoped
    @ContributesAndroidInjector
    abstract DynamicLinkFragment contributeDynamicLinkFragment();

}