package com.prl.myapplication.coroutinetest

import kotlinx.coroutines.*
import kotlin.random.Random

suspend fun main() {
    val c = GlobalScope.launch {
        val result = async {
            println("In async start at ${System.currentTimeMillis()} on ${Thread.currentThread().name}")
            val r = stallForTime()
            println("After delay at ${System.currentTimeMillis()} on ${Thread.currentThread().name}")
            r
        }

        println("In launch at ${System.currentTimeMillis()} on ${Thread.currentThread().name}")
        val res = result.await()
        println("result-$res at ${System.currentTimeMillis()} on ${Thread.currentThread().name}")
    }
    println("Main at ${System.currentTimeMillis()} on ${Thread.currentThread().name}")
    c.join()
    println("After join at ${System.currentTimeMillis()}")
}


private suspend fun stallForTime(): Int {
    return withContext(Dispatchers.IO) {
        println("stall at ${System.currentTimeMillis()} on ${Thread.currentThread().name}")
        delay(2000)
        return@withContext Random.nextInt(1, 100)
    }
}