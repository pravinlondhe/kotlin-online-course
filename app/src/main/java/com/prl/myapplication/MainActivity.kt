package com.prl.myapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.prl.myapplication.MockGenerator.getStubMediaList
import com.prl.myapplication.MockGenerator.printStubData
import com.prl.myapplication.data.model.MediaItem
import com.prl.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity(), Logger {
    private val mediaAdapter by lazy {
        MediaAdapter(listOf()) {
            d("Clicked:$it")
        }
    }
    private lateinit var binding: ActivityMainBinding
    private val activityScope by lazy {
        CoroutineScope(Dispatchers.Main + Job())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        v("OnCreate start")
        binding.rvMedia.apply {
            adapter = mediaAdapter
        }
        updateList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.photo -> updateList(Photo)
            R.id.video -> updateList(Video)
            R.id.all -> updateList()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun updateList(mediaType: MediaType = All) {

        activityScope.launch {
            binding.progressBar.visibility = View.VISIBLE
            d("I am on thread:${Thread.currentThread().name}")
            val list: List<MediaItem>
            withContext(Dispatchers.IO) {
                d("I am on thread(in IO):${Thread.currentThread().name}")
                val d = async { getStubMediaList(mediaType) }
                async { printStubData() }
                list = d.await()
                d("List:$list")
                withContext(Dispatchers.Main) {
                    mediaAdapter.data = list
                    binding.progressBar.visibility = View.INVISIBLE
                }
            }
        }
    }
}