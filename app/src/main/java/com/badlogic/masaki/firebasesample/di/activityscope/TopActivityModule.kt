package com.badlogic.masaki.firebasesample.di.activityscope

import android.support.v7.app.AppCompatActivity
import com.badlogic.masaki.firebasesample.data.repository.DynamicLinkDataSource
import com.badlogic.masaki.firebasesample.di.annotation.ActivityScoped
import com.badlogic.masaki.firebasesample.di.annotation.FragmentScoped
import com.badlogic.masaki.firebasesample.di.annotation.Repository
import com.badlogic.masaki.firebasesample.domain.usecase.top.TopUseCase
import com.badlogic.masaki.firebasesample.domain.usecase.top.TopUseCaseImpl
import com.badlogic.masaki.firebasesample.presentation.top.TopActivity
import com.badlogic.masaki.firebasesample.presentation.top.TopContract
import com.badlogic.masaki.firebasesample.presentation.top.TopFragment
import com.badlogic.masaki.firebasesample.presentation.top.TopPresenter
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class TopActivityModule {

    @Module
    companion object {

        @Provides @JvmStatic @ActivityScoped
        internal fun provideActivity(activity: TopActivity): AppCompatActivity {
            return activity
        }

        @Provides @JvmStatic @ActivityScoped
        internal fun provideTopUseCase(@Repository repository: DynamicLinkDataSource): TopUseCase {
            return TopUseCaseImpl(repository)
        }

        @Provides @JvmStatic @ActivityScoped
        internal fun provideTopPresenter(presenter: TopPresenter): TopContract.Presenter {
            return presenter
        }
    }

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeTopFragment(): TopFragment
}