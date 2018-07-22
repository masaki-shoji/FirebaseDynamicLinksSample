package com.badlogic.masaki.firebasesample.util

import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Singleton
class NetworkIOExecutor : Executor {

    companion object {
        private const val CORE_POOL_SIZE = 3
    }

    private val networkIO: Executor = Executors.newFixedThreadPool(CORE_POOL_SIZE)

    override fun execute(command: Runnable) {
        networkIO.execute(command)
    }
}