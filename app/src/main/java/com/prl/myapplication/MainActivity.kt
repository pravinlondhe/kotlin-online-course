package com.prl.myapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.prl.myapplication.MockGenerator.getStubMediaList
import com.prl.myapplication.MockGenerator.getStubPhotoList
import com.prl.myapplication.MockGenerator.getStubVideoList
import com.prl.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Logger {
    private val mediaAdapter by lazy {
        MediaAdapter(getStubMediaList()) {
            d("Clicked:$it")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        v("OnCreate start")
        binding.rvMedia.apply {
            adapter = mediaAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.photo -> mediaAdapter.data = getStubPhotoList()
            R.id.video -> mediaAdapter.data = getStubVideoList()
            R.id.all -> mediaAdapter.data = getStubMediaList()
        }
        return super.onOptionsItemSelected(item)
    }
}