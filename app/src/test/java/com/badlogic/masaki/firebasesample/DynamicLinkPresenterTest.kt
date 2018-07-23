package com.badlogic.masaki.firebasesample

import com.badlogic.masaki.firebasesample.domain.model.DeepLink
import com.badlogic.masaki.firebasesample.domain.usecase.dynamiclink.DynamicLinkUseCase
import com.badlogic.masaki.firebasesample.presentation.dynamiclink.DynamicLinkContract
import com.badlogic.masaki.firebasesample.presentation.dynamiclink.DynamicLinkPresenter
import com.badlogic.masaki.firebasesample.presentation.dynamiclink.item.DynamicLinkItem
import com.badlogic.masaki.firebasesample.presentation.dynamiclink.mapper.Mapper
import com.badlogic.masaki.firebasesample.util.ApplicationExecutor
import com.badlogic.masaki.firebasesample.util.TestAppExecutors
import com.google.android.gms.tasks.Task
import com.google.firebase.dynamiclinks.PendingDynamicLinkData
import com.nhaarman.mockitokotlin2.*
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mock
import org.mockito.Captor
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class DynamicLinkPresenterTest {

    private val mAppExecutors: ApplicationExecutor = TestAppExecutors()

    @Mock
    lateinit var mTask: Task<PendingDynamicLinkData>

    @Mock
    lateinit var mItem: DynamicLinkItem

    @Mock
    lateinit var mMapper: Mapper<DynamicLinkItem>

    @Mock
    lateinit var mUseCase: DynamicLinkUseCase

    @Mock
    lateinit var mUseCaseCallback: DynamicLinkUseCase.Callback

    @Mock
    lateinit var mView: DynamicLinkContract.View

    @Captor
    lateinit var mMapperCallbackCaptor: ArgumentCaptor<Mapper.Callback>// = ArgumentCaptor.forClass(Mapper.Callback::class.java)

    lateinit var mPresenter: DynamicLinkPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mPresenter = DynamicLinkPresenter(mItem,
                        mMapper,
                        mUseCase,
                        mAppExecutors)
    }

    @Test
    fun test() {
        `when`(mItem.deepLinkTask).thenReturn(mTask)
        mPresenter.setView(mView).handleDynamicLinkItem()

        verify(mMapper).toDeepLink(eq(mItem), capture(mMapperCallbackCaptor))

        val deepLink = DeepLink("https", "com.badlogic.masaki.firebasesample", -1, "/oss")
        mMapperCallbackCaptor.value.onSuccess(deepLink)

        verify(mUseCase).handleDeepLink(eq(deepLink), any())
        verify(mView, never()).onDynamicLinkHandlingErrorOccurred(any())
    }
}