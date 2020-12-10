package com.prl.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.ViewHolder.showToast(msg: String, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(itemView.context, msg, duration).show()
}

fun ViewGroup.inflate(@LayoutRes layout: Int): View = LayoutInflater.from(context).inflate(layout, this, false)
