package com.example.saleheretestapplication.data.model

data class GoalDetail(
    var img: String? = null,
    var activeValues: String? = null,
    var recommendValues: String? = null,
    var percent: Int? = 0,
    var description: String? = null,
    var status: Int? = 0,
    var countdownDate: String? = null
)