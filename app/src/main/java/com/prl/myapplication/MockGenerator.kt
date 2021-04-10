package com.prl.myapplication

import android.util.Log.d
import com.prl.myapplication.data.model.MediaItem
import kotlinx.coroutines.delay

object MockGenerator {

    suspend fun printStubData() {
        for (i in 1..50) {
            delay(100)
            d(
                javaClass.simpleName,
                "$i Thread:${Thread.currentThread().name} ${System.currentTimeMillis()}"
            )
        }
    }

    suspend fun getStubMediaList(mediaType: MediaType = All): List<MediaItem> {
        d(
            javaClass.simpleName,
            "I am on thread(in IO)-0:${Thread.currentThread().name} at ${System.currentTimeMillis()}"
        )
        delay(2000)
        d(
            javaClass.simpleName,
            "I am on thread(in IO):${Thread.currentThread().name} at ${System.currentTimeMillis()}"
        )
        val list = listOf(
            MediaItem(
                "Tom Cruise",
                "https://c4.wallpaperflare.com/wallpaper/692/291/745/best-actor-tom-cruise-face-photo-wallpaper-preview.jpg",
                Video
            ),
            MediaItem(
                "Scarlett Johansson",
                "https://c4.wallpaperflare.com/wallpaper/808/577/113/scarlett-johansson-face-image-wallpaper-preview.jpg"
            ),
            MediaItem(
                "Akshay Kumar",
                "https://c4.wallpaperflare.com/wallpaper/977/879/649/akshay-kumar-comedy-movies-wallpaper-preview.jpg"
            ),
            MediaItem(
                "Jason Statham",
                "https://c4.wallpaperflare.com/wallpaper/985/310/556/jason-statham-look-face-actor-wallpaper-preview.jpg"
            ),
            MediaItem(
                "Chris Hemsworth",
                "https://c4.wallpaperflare.com/wallpaper/762/936/854/chris-hemsworth-celebrities-star-movie-actor-short-hair-face-blue-eyes-chris-hemsworth-wallpaper-preview.jpg",
            ),
            MediaItem(
                "Katy Perry",
                "https://c4.wallpaperflare.com/wallpaper/892/431/671/katy-perry-face-eyes-celebrity-makeup-wallpaper-preview.jpg",
                Video
            ),
            MediaItem(
                "Tom Cruise",
                "https://c4.wallpaperflare.com/wallpaper/692/291/745/best-actor-tom-cruise-face-photo-wallpaper-preview.jpg",
                Video
            ),
            MediaItem(
                "Scarlett Johansson",
                "https://c4.wallpaperflare.com/wallpaper/808/577/113/scarlett-johansson-face-image-wallpaper-preview.jpg"
            ),
            MediaItem(
                "Akshay Kumar",
                "https://c4.wallpaperflare.com/wallpaper/977/879/649/akshay-kumar-comedy-movies-wallpaper-preview.jpg"
            ),
            MediaItem(
                "Jason Statham",
                "https://c4.wallpaperflare.com/wallpaper/985/310/556/jason-statham-look-face-actor-wallpaper-preview.jpg",
                Video
            ),
            MediaItem(
                "Chris Hemsworth",
                "https://c4.wallpaperflare.com/wallpaper/762/936/854/chris-hemsworth-celebrities-star-movie-actor-short-hair-face-blue-eyes-chris-hemsworth-wallpaper-preview.jpg"
            ),
            MediaItem(
                "Katy Perry",
                "https://c4.wallpaperflare.com/wallpaper/892/431/671/katy-perry-face-eyes-celebrity-makeup-wallpaper-preview.jpg",
                Video
            )
        )
        return when (mediaType) {
            is Photo, Video -> list.filter { it.mediaType == mediaType }
            else -> list
        }
    }
}