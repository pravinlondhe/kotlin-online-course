package com.prl.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.prl.myapplication.data.model.MediaItem
import com.prl.myapplication.databinding.ItemMediaBinding

class MediaAdapter(private val data: List<MediaItem>) :
    RecyclerView.Adapter<MediaAdapter.MediaViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MediaViewHolder {
        return MediaViewHolder(ItemMediaBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MediaViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    class MediaViewHolder(binding: ItemMediaBinding) : RecyclerView.ViewHolder(binding.root) {
        private val title: TextView = binding.tvTitle
        private val bannerImage: ImageView = binding.ivMedia
        private val playIcon: ImageView = binding.ivPlay

        init {
            binding.root.setOnClickListener {
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