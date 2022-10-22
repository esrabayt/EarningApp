package com.esrakaya.earningapp.domain.model

import com.esrakaya.earningapp.ui.list.EarningListAdapter.EarningListItems
import com.esrakaya.earningapp.ui.list.EarningListAdapter.EarningListItems.InviteItem
import com.esrakaya.earningapp.ui.list.EarningListAdapter.EarningListItems.UserItem

data class EarningModel(
    val userList: List<UserModel>,
    val totalEarned: Int,
    val potentialEarned: Int,
    val maximumEarning: Int,
    val paidAmount: Int
) {
    val items: List<EarningListItems>
        get() = buildList {
            addAll(userList.map(::UserItem))
            add(InviteItem)
        }
}

data class UserModel(
    val firstName: String,
    val lastName: String,
    val totalEarned: Int,
    val isEarned: Boolean
) {
    val fullName: String
        get() = "$firstName $lastName"
}