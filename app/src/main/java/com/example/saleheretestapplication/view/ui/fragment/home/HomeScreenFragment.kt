package com.example.saleheretestapplication.view.ui.fragment.home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.saleheretestapplication.R
import com.example.saleheretestapplication.data.model.GoalDetail
import com.example.saleheretestapplication.databinding.FragmentHomeScreenBinding
import com.example.saleheretestapplication.view.adapter.home.GoalAdapter
import com.example.saleheretestapplication.view.adapter.base.ImageAdapter
import com.example.saleheretestapplication.viewmodel.HomeViewModel

class HomeScreenFragment : Fragment() {

    private var _binding: FragmentHomeScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (_binding == null) {
            _binding = FragmentHomeScreenBinding.inflate(
                inflater, container, false
            )
        }
        initView()
        initViewModel()
        initEvent()
        return binding.root

    }

    @SuppressLint("SetTextI18n")
    private fun initView() {
        binding.textCountGoal.text = getString(R.string.target_goal_unit, "3")
        binding.txtSaving.text = "37,500"
        initRvGoalList()
        initRvBestOfferList()
        initRvSuggestList()
    }

    private fun initEvent() {
        binding.constraintGoalButton.setOnClickListener {
            it?.findNavController()?.navigate(R.id.action_homeFragment_to_goalDetailFragment)
        }
    }

    private fun initViewModel() {

    }

    private fun initRvGoalList() {
        val rvGoal = binding.rvGoalList
        rvGoal.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rvGoal.setHasFixedSize(true)

        val goal = GoalDetail(
            img = "",
            activeValues = "16,500",
            recommendValues = "16,500",
            percent = 1,
            description = "ทริปเที่ยวไทย",
            status = 1,
            countdownDate = "45 days left"
        )

        val listGoal = listOf(goal, goal, goal, goal)

        binding.rvGoalList.adapter = GoalAdapter(listGoal)
    }

    private fun initRvBestOfferList() {
        val rvBestOffer = binding.rvBestOffer
        rvBestOffer.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rvBestOffer.setHasFixedSize(true)

        val listImage = listOf(
            "https://img.salehere.co.th/p/1200x0/2020/05/21/qftlxc3xx17p.jpg",
            "https://img.salehere.co.th/p/1200x0/2020/05/21/qftlxc3xx17p.jpg",
            "https://img.salehere.co.th/p/1200x0/2020/05/21/qftlxc3xx17p.jpg"
        )

        binding.rvBestOffer.adapter = ImageAdapter(listImage)
    }

    private fun initRvSuggestList() {
        val rvSuggest = binding.rvSuggest
        rvSuggest.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rvSuggest.setHasFixedSize(true)

        val listImage = listOf(
            "https://img.salehere.co.th/p/1200x0/2023/01/06/reomfyd0r5gs.jpg",
            "https://img.salehere.co.th/p/1200x0/2023/01/06/reomfyd0r5gs.jpg",
            "https://img.salehere.co.th/p/1200x0/2023/01/06/reomfyd0r5gs.jpg"
        )

        binding.rvSuggest.adapter = ImageAdapter(listImage)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}