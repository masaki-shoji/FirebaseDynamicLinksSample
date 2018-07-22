package com.badlogic.masaki.firebasesample.presentation.dynamiclink

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.badlogic.masaki.firebasesample.di.annotation.ActivityScoped
import com.badlogic.masaki.firebasesample.presentation.top.TopActivity
import dagger.android.support.DaggerFragment
import javax.inject.Inject

@ActivityScoped
class DynamicLinkFragment
    @Inject constructor() : DaggerFragment(), DynamicLinkContract.View {

    @Inject
    lateinit var mPresenter: DynamicLinkContract.Presenter

    companion object {
        fun newInstance(): DynamicLinkFragment = DynamicLinkFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mPresenter.setView(this).handleDynamicLinkItem()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.dropView()
    }

    override fun onDeepLinkHandled() {
        activity?.let {
            val i = Intent(it, TopActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION
                    or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    or Intent.FLAG_ACTIVITY_CLEAR_TOP)
            it.overridePendingTransition(0, 0)

            it.startActivity(i)
            it.finish()
        }
    }

    override fun onDynamicLinkHandlingErrorOccurred(e: Throwable) {
        Toast.makeText(activity, e.message, Toast.LENGTH_SHORT).show()
    }

    override fun isActive() = isAdded
}
