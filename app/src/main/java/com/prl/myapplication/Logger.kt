package com.prl.myapplication

import android.util.Log

interface Logger {

    val tag: String
        get() = javaClass.simpleName

    fun d(msg: String) {
        Log.d(tag, msg)
    }

    fun e(msg: String) {
        Log.e(tag, msg)
    }

    fun v(msg: String) {
        Log.v(tag, msg)
    }

    fun w(msg: String) {
        Log.w(tag, msg)
    }

    fun i(msg: String) {
        Log.i(tag, msg)
    }
}