package com.prl.myapplication

import com.prl.myapplication.data.model.MediaItem

object MockGenerator {

    fun getStubMediaList() = listOf<MediaItem>(
        MediaItem(
            "Tom Cruise",
            "https://c4.wallpaperflare.com/wallpaper/692/291/745/best-actor-tom-cruise-face-photo-wallpaper-preview.jpg",
            MediaItem.MediaType.VIDEO
        ),
        MediaItem(
            "Scarlett Johansson",
            "https://c4.wallpaperflare.com/wallpaper/808/577/113/scarlett-johansson-face-image-wallpaper-preview.jpg",
            MediaItem.MediaType.PHOTO
        ),
        MediaItem(
            "Akshay Kumar",
            "https://c4.wallpaperflare.com/wallpaper/977/879/649/akshay-kumar-comedy-movies-wallpaper-preview.jpg",
            MediaItem.MediaType.VIDEO
        ),
        MediaItem(
            "Jason Statham",
            "https://c4.wallpaperflare.com/wallpaper/985/310/556/jason-statham-look-face-actor-wallpaper-preview.jpg",
            MediaItem.MediaType.PHOTO
        ),
        MediaItem(
            "Chris Hemsworth",
            "https://c4.wallpaperflare.com/wallpaper/762/936/854/chris-hemsworth-celebrities-star-movie-actor-short-hair-face-blue-eyes-chris-hemsworth-wallpaper-preview.jpg",
            MediaItem.MediaType.PHOTO
        ),
        MediaItem(
            "Katy Perry",
            "https://c4.wallpaperflare.com/wallpaper/892/431/671/katy-perry-face-eyes-celebrity-makeup-wallpaper-preview.jpg",
            MediaItem.MediaType.VIDEO
        ),
        MediaItem(
            "Tom Cruise",
            "https://c4.wallpaperflare.com/wallpaper/692/291/745/best-actor-tom-cruise-face-photo-wallpaper-preview.jpg",
            MediaItem.MediaType.VIDEO
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
            MediaItem.MediaType.VIDEO
        ),
        MediaItem(
            "Chris Hemsworth",
            "https://c4.wallpaperflare.com/wallpaper/762/936/854/chris-hemsworth-celebrities-star-movie-actor-short-hair-face-blue-eyes-chris-hemsworth-wallpaper-preview.jpg"
        ),
        MediaItem(
            "Katy Perry",
            "https://c4.wallpaperflare.com/wallpaper/892/431/671/katy-perry-face-eyes-celebrity-makeup-wallpaper-preview.jpg",
            MediaItem.MediaType.VIDEO
        )
    )
}