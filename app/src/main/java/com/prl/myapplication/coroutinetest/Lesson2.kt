package com.prl.myapplication.coroutinetest

import kotlinx.coroutines.*

// Test Join and Cancel the coroutine

fun main() = runBlocking {
    val c1 = launch {
//        delay(1000)
        println("World")
    }

    print("Hello, ")
    cancelSample()

    c1.join()
}


fun cancelSample() = runBlocking {
    val c1 = launch(Dispatchers.Default) {
        customSuspendFunctionUsingIsActive()
    }

    delay(150)
    c1.cancelAndJoin()
    println("done")
}

suspend fun customSuspendFunction() {
    repeat(200) {
        print(".")
        yield()
        Thread.sleep(10)
    }
}

fun customSuspendFunctionUsingIsActive() = GlobalScope.launch {
    repeat(200) {
        if (!isActive) throw CancellationException()
        print(".")
        Thread.sleep(10)
    }
}
