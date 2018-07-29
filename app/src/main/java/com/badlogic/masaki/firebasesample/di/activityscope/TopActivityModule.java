package com.badlogic.masaki.firebasesample.di.activityscope;

import android.support.v7.app.AppCompatActivity;
import com.badlogic.masaki.firebasesample.data.repository.DynamicLinkDataSource;
import com.badlogic.masaki.firebasesample.di.annotation.ActivityScoped;
import com.badlogic.masaki.firebasesample.di.annotation.FragmentScoped;
import com.badlogic.masaki.firebasesample.di.annotation.Repository;
import com.badlogic.masaki.firebasesample.domain.usecase.top.TopUseCase;
import com.badlogic.masaki.firebasesample.domain.usecase.top.TopUseCaseImpl;
import com.badlogic.masaki.firebasesample.presentation.top.TopActivity;
import com.badlogic.masaki.firebasesample.presentation.top.TopContract;
import com.badlogic.masaki.firebasesample.presentation.top.TopFragment;
import com.badlogic.masaki.firebasesample.presentation.top.TopPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class TopActivityModule {

    @Binds @ActivityScoped
    abstract AppCompatActivity provideActivity(TopActivity activity);

    @Provides @ActivityScoped
    static TopUseCase provideTopUseCase(@Repository DynamicLinkDataSource repository) {
        return new TopUseCaseImpl(repository);
    }

    @Binds @ActivityScoped
    abstract TopContract.Presenter provideTopPresenter(TopPresenter presenter);

    @FragmentScoped
    @ContributesAndroidInjector
    abstract TopFragment contributeTopFragment();
}