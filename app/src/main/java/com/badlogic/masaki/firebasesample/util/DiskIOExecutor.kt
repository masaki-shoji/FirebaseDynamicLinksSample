package com.badlogic.masaki.firebasesample.util

import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Singleton
class DiskIOExecutor : Executor {

    private val diskIO: Executor = Executors.newSingleThreadExecutor()

    override fun execute(command: Runnable) {
        diskIO.execute(command)
    }
}