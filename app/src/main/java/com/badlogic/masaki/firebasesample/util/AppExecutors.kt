package com.badlogic.masaki.firebasesample.util

import java.util.concurrent.Executor
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class AppExecutors
    @Inject constructor(@Named("mainThread") private val mainThread: Executor,
                        @Named("networkIO") private val networkIO: Executor,
                        @Named("diskIO") private val diskIO: Executor,
                        @Named("computation") private val computation: Executor
                        ): ApplicationExecutor {

    override fun mainThread(): Executor {
        return mainThread
    }

    override fun networkIO(): Executor {
        return networkIO
    }

    override fun computation(): Executor {
        return computation
    }

    override fun diskIO(): Executor {
        return diskIO
    }
}