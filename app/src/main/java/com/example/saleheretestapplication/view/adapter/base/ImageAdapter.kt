package com.example.saleheretestapplication.view.adapter.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.saleheretestapplication.databinding.ItemImageListBinding

class ImageAdapter(
    private var items: List<String>
) : RecyclerView.Adapter<ImageRecyclerViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ImageRecyclerViewHolder {
        val itemView = ItemImageListBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return ImageRecyclerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ImageRecyclerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = this.items.size
}

class ImageRecyclerViewHolder(
    private val viewBinding: ItemImageListBinding
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(
        data: String
    ) {
        Glide.with(viewBinding.root).load(data).into(viewBinding.imgBestOffer)
    }
}