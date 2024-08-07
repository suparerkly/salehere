package com.example.saleheretestapplication.view.adapter.achievement

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.saleheretestapplication.databinding.ItemAchievementDetailBinding

class AchievementAdapter(
    private var items: List<String>
) : RecyclerView.Adapter<AchievementRecyclerViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): AchievementRecyclerViewHolder {
        val itemView = ItemAchievementDetailBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return AchievementRecyclerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AchievementRecyclerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = this.items.size
}

class AchievementRecyclerViewHolder(
    private val viewBinding: ItemAchievementDetailBinding
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(
        data: String
    ) {
        viewBinding.txtAchievement.text = data
    }
}