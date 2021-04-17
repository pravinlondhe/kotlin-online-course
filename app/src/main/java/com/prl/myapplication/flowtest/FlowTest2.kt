package com.prl.myapplication.flowtest

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

suspend fun main() {
    val c = GlobalScope.async(Dispatchers.IO) {
        testFlow().collect {
            println("Collected:$it")
            testFlow().collect {
                println("collected inner:$it")
            }
        }

        testFlow().collect {
            println("second collect:$it")
        }
    }
    c.join()
}

fun testFlow() = flow {
//    delay(100)
    for (i in 1..10) {
        println("emiting:$i")
        emit(i)
    }
}.map {
//    delay(100)
    println("mapping:${it * it}")
    it * it
}