package com.badlogic.masaki.firebasesample.util

import java.util.concurrent.Executor

interface ApplicationExecutor {
    fun mainThread(): Executor
    fun networkIO(): Executor
    fun computation(): Executor
    fun diskIO(): Executor
}