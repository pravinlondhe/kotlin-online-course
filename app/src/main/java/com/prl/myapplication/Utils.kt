package com.prl.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

sealed class MediaType
object Photo : MediaType()
object Video : MediaType()
object All : MediaType()

fun RecyclerView.ViewHolder.showToast(msg: String?, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(itemView.context, msg, duration).show()
}

fun ViewGroup.inflate(@LayoutRes layout: Int): View =
    LayoutInflater.from(context).inflate(layout, this, false)

inline fun <reified T : Activity> Context.startActivity() {
    startActivity(Intent(this, T::class.java))
}

// Lambada with receiver

//1. let -> Takes it returns last statement
inline fun <T, U> T.myLet(body: (T) -> U): U {
    return body(this)
}

//2. run -> Takes this returns last statement
inline fun <T, U> T.myRun(body: T.() -> U): U {
    return body()
}

//2.1 run -> takes nothing returns last statement
inline fun <T> myRun2(body: () -> T): T {
    return body()
}

//3. also -> Takes it returns this object
inline fun <T> T.myAlso(body: (T) -> Unit): T {
    body(this)
    return this
}

//4. apply -> Takes this returns this object
inline fun <T> T.myApply(body: T.() -> Unit): T {
    body()
    return this
}

//5. with -> Takes this returns last statement
inline fun <T, U> myWith(receiver: T, body: T.() -> U): U {
    return receiver.body()
}