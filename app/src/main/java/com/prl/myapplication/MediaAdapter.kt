package com.prl.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.prl.myapplication.data.model.MediaItem
import com.prl.myapplication.databinding.ItemMediaBinding
import kotlin.properties.Delegates

class MediaAdapter(media: List<MediaItem>, private val itemListener: (String) -> Unit) :
    RecyclerView.Adapter<MediaAdapter.MediaViewHolder>() {

    var data: List<MediaItem> by Delegates.observable(media) { _, old, new ->
        if (old != new) {
            this.data = new
            notifyDataSetChanged()
        }
    }

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

    inner class MediaViewHolder(private val binding: ItemMediaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            with(binding) {
                root.setOnClickListener {
                    itemListener("${tvTitle.text}")
                    showToast("${tvTitle.text}")
                }
            }
        }

        fun bind(mediaItem: MediaItem) {
            with(binding) {
                tvTitle.text = mediaItem.name
                ivMedia.load(mediaItem.imageUrl)
                when (mediaItem.mediaType) {
                    is Video -> ivPlay.visibility = View.VISIBLE
                    else -> ivPlay.visibility = View.GONE
                }
            }
        }
    }
}