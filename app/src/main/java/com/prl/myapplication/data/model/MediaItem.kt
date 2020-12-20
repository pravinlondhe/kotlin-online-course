package com.prl.myapplication.data.model

import com.prl.myapplication.MediaType
import com.prl.myapplication.Photo

data class MediaItem(
    val name: String,
    val imageUrl: String,
    val mediaType: MediaType = Photo
)
