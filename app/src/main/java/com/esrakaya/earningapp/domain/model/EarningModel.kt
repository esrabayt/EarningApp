package com.esrakaya.earningapp.domain.model

data class EarningModel(
    val userList: List<UserModel>,
    val totalEarned: Int,
    val potentialEarned: Int,
    val maximumEarning: Int,
    val paidAmount: Int
)

data class UserModel(
    val firstName: String,
    val lastName: String,
    val totalEarned: Int,
    val isEarned: Boolean
)