package com.prl.myapplication

import android.view.LayoutInflater
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
    ) = MediaViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_media, parent, false)
    )

    override fun onBindViewHolder(holder: MediaAdapter.MediaViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    class MediaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = view.tvTitle
        private val bannerImage: ImageView = view.ivMedia

        init {
            view.setOnClickListener {
                showToast("${title.text}")
            }
        }

        fun bind(mediaItem: MediaItem) {
            title.text = mediaItem.name
            bannerImage.load(mediaItem.imageUrl)
        }
    }
}