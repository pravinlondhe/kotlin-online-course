package com.prl.myapplication.flowtest

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

suspend fun main() {
    val c = GlobalScope.launch {
        randomPercentagesWithChannel(20, 100).consumeEach() {
            println("received:$it at ${System.currentTimeMillis()}")
        }
    }
    c.join()
}

private fun randomPercentagesWithChannel(count: Int, delay: Long) = Channel<Int>().also { channel ->
    GlobalScope.launch {
        for (i in 0..count) {
            delay(delay)
            channel.send(Random.nextInt(1, 100))
        }
    }
}
