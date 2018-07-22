package com.badlogic.masaki.firebasesample.di.activityscope

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import com.badlogic.masaki.firebasesample.data.repository.DynamicLinkDataSource
import com.badlogic.masaki.firebasesample.di.annotation.ActivityScoped
import com.badlogic.masaki.firebasesample.di.annotation.FragmentScoped
import com.badlogic.masaki.firebasesample.di.annotation.Repository
import com.badlogic.masaki.firebasesample.domain.usecase.dynamiclink.DynamicLinkUseCase
import com.badlogic.masaki.firebasesample.domain.usecase.dynamiclink.DynamicUseCaseImpl
import com.badlogic.masaki.firebasesample.presentation.dynamiclink.item.DynamicLinkItem
import com.badlogic.masaki.firebasesample.presentation.dynamiclink.DynamicLinkActivity
import com.badlogic.masaki.firebasesample.presentation.dynamiclink.DynamicLinkContract
import com.badlogic.masaki.firebasesample.presentation.dynamiclink.DynamicLinkFragment
import com.badlogic.masaki.firebasesample.presentation.dynamiclink.DynamicLinkPresenter
import com.badlogic.masaki.firebasesample.presentation.dynamiclink.mapper.DeepLinkMapper
import com.badlogic.masaki.firebasesample.presentation.dynamiclink.mapper.Mapper
import com.google.android.gms.tasks.Task
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import com.google.firebase.dynamiclinks.PendingDynamicLinkData
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class DynamicLinkActivityModule {

    @Module
    companion object {

        @Provides @JvmStatic @ActivityScoped
        internal fun provideDynamicLinkActivity(activity: DynamicLinkActivity): AppCompatActivity
                = activity

        @Provides @JvmStatic @ActivityScoped
        internal fun provideInent(activity: AppCompatActivity): Intent
                = activity.intent

        @Provides @JvmStatic @ActivityScoped
        internal fun provideFirebaseDynamicLinks(): FirebaseDynamicLinks
                = FirebaseDynamicLinks.getInstance()

        @Provides @JvmStatic
        internal fun provideTask(firebaseDynamicLinks: FirebaseDynamicLinks,
                                 intent: Intent): Task<PendingDynamicLinkData>
                = firebaseDynamicLinks.getDynamicLink(intent)

        @Provides @JvmStatic
        internal fun provideDynamicLinkItem(task: Task<PendingDynamicLinkData>): DynamicLinkItem
                = DynamicLinkItem(task)

        @Provides @JvmStatic @ActivityScoped
        internal fun provideDynamicLinkMapper(mapper: DeepLinkMapper): Mapper<DynamicLinkItem>
                = mapper

        @Provides @JvmStatic @ActivityScoped
        internal fun provideDynamicLinkPresenter(presenter: DynamicLinkPresenter): DynamicLinkContract.Presenter
                = presenter

        @Provides @JvmStatic @ActivityScoped
        internal fun provideDynamicLinkUseCase(@Repository repository: DynamicLinkDataSource)
                : DynamicLinkUseCase {
            return DynamicUseCaseImpl(repository)
        }
    }

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeDynamicLinkFragment(): DynamicLinkFragment

}