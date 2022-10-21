package com.esrakaya.earningapp.data.model

import com.google.gson.annotations.SerializedName

data class EarningResponse(
    @SerializedName("userList")
    val userList: List<UserResponse>?,
    @SerializedName("totalEarned")
    val totalEarned: Int?,
    @SerializedName("potentialEarned")
    val potentialEarned: Int?,
    @SerializedName("maximumEarning")
    val maximumEarning: Int?,
    @SerializedName("paidAmount")
    val paidAmount: Int?
) {

    data class UserResponse(
        @SerializedName("firstName")
        val firstName: String?,
        @SerializedName("lastName")
        val lastName: String?,
        @SerializedName("totalEarned")
        val totalEarned: Int?,
        @SerializedName("isEarned")
        val isEarned: Boolean?
    )
}