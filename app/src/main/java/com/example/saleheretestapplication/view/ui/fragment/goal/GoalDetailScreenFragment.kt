package com.example.saleheretestapplication.view.ui.fragment.goal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.saleheretestapplication.databinding.FragmentGoalScreenBinding
import com.example.saleheretestapplication.view.adapter.goal.GoalTypeAdapter

class GoalDetailScreenFragment : Fragment() {

    private var _binding: FragmentGoalScreenBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (_binding == null) {
            _binding = FragmentGoalScreenBinding.inflate(
                inflater, container, false
            )
        }
        initView()
        initViewModel()
        initEvent()
        return binding.root

    }

    private fun initView() {
        initRvAchievementList()
    }

    private fun initEvent() {
    }

    private fun initViewModel() {

    }

    private fun initRvAchievementList() {
        val rvAchievement = binding.rvGoalType
        rvAchievement.layoutManager =
            GridLayoutManager(activity, 3)
        rvAchievement.setHasFixedSize(true)

        val goalList =
            listOf("Travel", "Education", "Invest", "Clothing", "Education")
        binding.rvGoalType.adapter = GoalTypeAdapter(goalList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}