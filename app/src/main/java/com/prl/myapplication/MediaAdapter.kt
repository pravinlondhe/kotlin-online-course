package com.prl.myapplication

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.prl.myapplication.data.model.MediaItem
import kotlinx.android.synthetic.main.item_media.view.*

class MediaAdapter(private val data: List<MediaItem>) :
    RecyclerView.Adapter<MediaAdapter.MediaViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = MediaViewHolder(parent.inflate(R.layout.item_media))

    override fun onBindViewHolder(holder: MediaAdapter.MediaViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    class MediaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = view.tvTitle
        private val bannerImage: ImageView = view.ivMedia
        private val playIcon: ImageView = view.ivPlay

        init {
            view.setOnClickListener {
                showToast("${title.text}")
            }
        }

        fun bind(mediaItem: MediaItem) {
            title.text = mediaItem.name
            bannerImage.load(mediaItem.imageUrl)
            when (mediaItem.mediaType) {
                MediaItem.MediaType.PHOTO -> playIcon.visibility = View.GONE
                MediaItem.MediaType.VIDEO -> playIcon.visibility = View.VISIBLE
            }
        }
    }
}