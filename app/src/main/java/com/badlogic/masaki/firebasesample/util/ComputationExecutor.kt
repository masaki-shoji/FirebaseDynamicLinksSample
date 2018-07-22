package com.badlogic.masaki.firebasesample.util

import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Singleton
class ComputationExecutor : Executor {

    companion object {
        private const val CORE_POOL_SIZE = 2
    }

    private val computation: Executor = Executors.newFixedThreadPool(CORE_POOL_SIZE)

    override fun execute(command: Runnable) = computation.execute(command)
}