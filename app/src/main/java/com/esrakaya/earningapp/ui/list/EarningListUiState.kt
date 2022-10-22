package com.esrakaya.earningapp.ui.list

import com.esrakaya.earningapp.domain.model.EarningModel
import com.esrakaya.earningapp.domain.utils.orZero
import com.esrakaya.earningapp.ui.list.EarningListAdapter.EarningListItems
import com.esrakaya.earningapp.ui.list.EarningListAdapter.EarningListItems.UserItem

data class EarningListUiState(
    val earningModel: EarningModel? = null
) {
    val items: List<EarningListItems>
        get() = buildList {
            val userList = earningModel?.userList.orEmpty()

            addAll(userList.map(::UserItem))
            add(EarningListItems.InviteItem)
        }

    val totalEarned: Int
        get() = earningModel?.totalEarned.orZero()

    val potentialEarned: Int
        get() = earningModel?.potentialEarned.orZero()

    val maximumEarning: Int
        get() = earningModel?.maximumEarning.orZero()
}