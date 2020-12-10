package com.prl.myapplication.data.model

data class MediaItem(
    val name: String,
    val imageUrl: String,
    val mediaType: MediaType = MediaType.PHOTO
) {
    enum class MediaType {
        PHOTO,
        VIDEO
    }
}
