package com.badlogic.masaki.firebasesample.util

import java.util.concurrent.Executor

class TestAppExecutors : ApplicationExecutor {

    private class TestExecutor : Executor {
        override fun execute(command: Runnable) {
            command.run()
        }
    }

    private val mTestExecutor = TestExecutor()

    override fun diskIO(): Executor {
        return mTestExecutor
    }

    override fun mainThread(): Executor {
        return mTestExecutor
    }

    override fun networkIO(): Executor {
        return mTestExecutor
    }

    override fun computation(): Executor {
        return mTestExecutor
    }
}