package com.example.saleheretestapplication.view.adapter.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.saleheretestapplication.R
import com.example.saleheretestapplication.data.model.GoalDetail
import com.example.saleheretestapplication.databinding.ItemGoalDetailBinding

class GoalAdapter(
    private var items: List<GoalDetail>
) : RecyclerView.Adapter<GoalRecyclerViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): GoalRecyclerViewHolder {
        val itemView = ItemGoalDetailBinding.inflate(
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
    private val viewBinding: ItemGoalDetailBinding
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(
        data: GoalDetail
    ) {
        viewBinding.txtDescriptionGoal.text = data.description
        viewBinding.activeValues.text =
            viewBinding.root.context.getString(R.string.unit_text, data.activeValues)
        viewBinding.txtStatusGoal.text = if (data.status == 1) "Good" else "Unhappy"
        viewBinding.txtCountdownGoal.text = data.countdownDate
    }
}