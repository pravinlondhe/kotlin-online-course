package com.prl.myapplication.coroutinetest

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread

suspend fun main() {
    println("first launch Before:${Thread.currentThread().name}")
    delay(1000)
    println("first launch:${Thread.currentThread().name}")
    println("World")

    val c = GlobalScope.launch {
        println("Second launch Before:${Thread.currentThread().name}")
        delay(500)
        println("Second launch:${Thread.currentThread().name}")
        println("Other")
    }

    println("Hello, ")
//    createBillionThread()
    createBillionCoroutine()

    c.join()
}


fun createBillionThread() {
    val result = AtomicInteger()
    (1..1_00_000_00).forEach { _ ->
        thread {
            Thread.sleep(100)
            result.incrementAndGet()
        }
    }
    Thread.sleep(1000)
    println("thread result:$result")
}

fun createBillionCoroutine() {
    val result = AtomicInteger()
    (1..1_00_000_00).forEach { _ ->
        GlobalScope.launch {
            delay(100)
            result.incrementAndGet()
        }
    }
    Thread.sleep(1000)
    println("coroutine result:$result")
}