package com.prl.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.prl.myapplication.MockGenerator.getStubMediaList
import com.prl.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Logger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        v("OnCreate start")
        binding.rvMedia.apply {
            adapter = MediaAdapter(getStubMediaList())
        }
    }
}