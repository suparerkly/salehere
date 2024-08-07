package com.example.saleheretestapplication.view.ui.fragment.achievement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.saleheretestapplication.databinding.FragmentAchievementScreenBinding
import com.example.saleheretestapplication.view.adapter.achievement.AchievementAdapter

class AchievementScreenFragment : Fragment() {

    private var _binding: FragmentAchievementScreenBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (_binding == null) {
            _binding = FragmentAchievementScreenBinding.inflate(
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
        val rvAchievement = binding.rvAchievement
        rvAchievement.layoutManager =
            GridLayoutManager(activity, 3)
        rvAchievement.setHasFixedSize(true)

        val achievementList =
            listOf("quest1", "quest2", "quest3", "quest4", "quest5", "quest6", "quest7", "quest8")
        binding.rvAchievement.adapter = AchievementAdapter(achievementList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}