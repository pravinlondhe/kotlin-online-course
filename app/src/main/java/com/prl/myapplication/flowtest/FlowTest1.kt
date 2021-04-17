package com.prl.myapplication.flowtest

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlin.random.Random

suspend fun main() {

    val state: MutableStateFlow<Int> = MutableStateFlow(1)

    val c = GlobalScope.launch(Dispatchers.IO) {
        randomPercentages(10, 100).collect {
            println("Received:$it at ${System.currentTimeMillis()}")
        }
    }

    c.join()
}


private fun randomPercentages(count: Int, delay: Long) = flow {
    for (i in 0..count) {
        delay(delay)
        emit(Random.nextInt(1, 100))
    }
}