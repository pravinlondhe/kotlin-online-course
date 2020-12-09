package com.prl.myapplication

import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.ViewHolder.showToast(msg: String, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this.itemView.context, msg, duration).show()
}