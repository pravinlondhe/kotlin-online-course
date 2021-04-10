package com.prl.myapplication.coroutinetest

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


fun main() {
    val inputArray: Array<Int> = Array(2_000_000) {
        it
    }

    val time = measureTimeMillis {
        GlobalScope.launch {
            println(
                "resultCoroutine:${
                    calculateArraySumWithCoroutine(
                        inputArray,
                        0,
                        inputArray.size
                    )
                }"
            )
        }
    }
    println("time:${measureTimeMillis { calculateArraySum(inputArray, 0, inputArray.size) }}ms")
    println("result:${calculateArraySum(inputArray, 0, inputArray.size)}")
    println(time)
}

private suspend fun calculateArraySumWithCoroutine(
    inputArray: Array<Int>,
    low: Int,
    high: Int
): Long {
    return withContext(Dispatchers.IO) {
        return@withContext if (high - low <= THRESHOLD) {
            (low until high).map { inputArray[it].toLong() }.sum()
        } else {
            val mid = (low + high) / 2
            val left = async { calculateArraySum(inputArray, low, mid) }
            val rightResult = calculateArraySum(inputArray, mid, high)
            left.await() + rightResult
        }
    }
}

private fun calculateArraySum(inputArray: Array<Int>, low: Int, high: Int): Long {
    return if (high - low <= THRESHOLD) {
        (low until high).map { inputArray[it].toLong() }.sum()
    } else {
        val mid = (low + high) / 2
        val leftResult = calculateArraySum(inputArray, low, mid)
        val rightResult = calculateArraySum(inputArray, mid, high)
        leftResult + rightResult
    }
}

const val THRESHOLD = 5000

