package com.prl.myapplication.coroutinetest

import kotlinx.coroutines.*

suspend fun main() {
    val c1 = GlobalScope.launch(Dispatchers.Unconfined) {
        println("first launch before delay and running on ${Thread.currentThread().name}")
        stallForTime()
        println("first launch after delay and running on ${Thread.currentThread().name}")
    }

    val c2 = GlobalScope.launch {
        println("second launch before delay and running on ${Thread.currentThread().name}")
        stallForTime()
        println("second launch after delay and running on ${Thread.currentThread().name}")
    }

    println("End of main")
    c2.join()
//    c1.join()
}

private suspend fun stallForTime() {
    withContext(Dispatchers.IO) {
        println("Here i am in fun at start and running on ${Thread.currentThread().name}")
        delay(1000)
    }
}