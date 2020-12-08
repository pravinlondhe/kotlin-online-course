package com.prl.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.prl.myapplication.MockGenerator.getStubMediaList
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvMedia.apply {
            adapter = MediaAdapter(getStubMediaList())
        }
    }
}