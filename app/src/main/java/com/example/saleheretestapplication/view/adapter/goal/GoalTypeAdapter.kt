package com.example.saleheretestapplication.view.adapter.goal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.saleheretestapplication.databinding.ItemGoalTypeDetailBinding

class GoalTypeAdapter(
    private var items: List<String>
) : RecyclerView.Adapter<GoalRecyclerViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): GoalRecyclerViewHolder {
        val itemView = ItemGoalTypeDetailBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return GoalRecyclerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GoalRecyclerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = this.items.size
}

class GoalRecyclerViewHolder(
    private val viewBinding: ItemGoalTypeDetailBinding
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(
        data: String
    ) {
        viewBinding.txtGoalDescription.text = data
    }
}