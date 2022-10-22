package com.esrakaya.earningapp.ui.list

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.esrakaya.earningapp.R
import com.esrakaya.earningapp.databinding.ItemEarningBinding
import com.esrakaya.earningapp.databinding.ItemInviteBinding
import com.esrakaya.earningapp.domain.model.UserModel
import com.esrakaya.earningapp.ui.list.EarningListAdapter.EarningListItems
import com.esrakaya.earningapp.ui.list.EarningListAdapter.EarningListItems.InviteItem
import com.esrakaya.earningapp.ui.list.EarningListAdapter.EarningListItems.UserItem
import com.esrakaya.earningapp.utils.inflater

class EarningListAdapter : ListAdapter<EarningListItems, ViewHolder>(EarningListDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        ITEM_EARNING_VIEW_TYPE -> EarningListItemViewHolder(
            ItemEarningBinding.inflate(
                parent.context.inflater,
                parent,
                false
            )
        )
        ITEM_INVITE_VIEW_TYPE -> InviteItemViewHolder(
            ItemInviteBinding.inflate(
                parent.context.inflater,
                parent,
                false
            )
        )
        else -> throw IllegalStateException("Unexpected view type!")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        when (holder) {
            is EarningListItemViewHolder -> holder.bind(item as UserItem)
            is InviteItemViewHolder -> holder.bind(item as InviteItem)
            else -> throw IllegalStateException("Unexpected view type!")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is UserItem -> ITEM_EARNING_VIEW_TYPE
            InviteItem -> ITEM_INVITE_VIEW_TYPE
            else -> throw IllegalStateException("Unexpected view type!")
        }
    }

    inner class InviteItemViewHolder(
        private val binding: ItemInviteBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: InviteItem) = with(binding) {

        }
    }

    inner class EarningListItemViewHolder(
        private val binding: ItemEarningBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n", "NewApi")
        fun bind(item: UserItem) = with(binding) {
            tvName.text = item.userModel.fullName
            if (item.userModel.isEarned) {
                tvEarning.text = "+" + item.userModel.totalEarned + " €"
                tvEarning.setTextColor(itemView.context.resources.getColor(R.color.orange_3, null))
            } else {
                tvEarning.text = "0 €"
                tvEarning.setTextColor(itemView.context.resources.getColor(R.color.gray_2, null))
            }

        }
    }

    object EarningListDiffCallback : DiffUtil.ItemCallback<EarningListItems>() {
        override fun areItemsTheSame(
            oldItem: EarningListItems,
            newItem: EarningListItems
        ): Boolean {
            return when {
                oldItem is UserItem && newItem is UserItem -> {
                    oldItem.userModel == newItem.userModel
                }
                oldItem is InviteItem && newItem is InviteItem -> true
                else -> false
            }
        }

        override fun areContentsTheSame(
            oldItem: EarningListItems,
            newItem: EarningListItems
        ): Boolean {
            return when {
                oldItem is UserItem && newItem is UserItem -> {
                    oldItem == newItem
                }
                oldItem is InviteItem && newItem is InviteItem -> true
                else -> false
            }
        }
    }

    sealed class EarningListItems {
        data class UserItem(val userModel: UserModel) : EarningListItems()
        object InviteItem : EarningListItems()
    }

    companion object {
        private const val ITEM_EARNING_VIEW_TYPE = 0
        private const val ITEM_INVITE_VIEW_TYPE = 1
    }

}