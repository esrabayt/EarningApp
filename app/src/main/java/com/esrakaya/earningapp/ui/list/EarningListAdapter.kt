package com.esrakaya.earningapp.ui.list

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.esrakaya.earningapp.databinding.ItemEarningBinding
import com.esrakaya.earningapp.domain.model.UserModel
import com.esrakaya.earningapp.ui.list.EarningListAdapter.EarningListItemViewHolder
import com.esrakaya.earningapp.utils.inflater

class EarningListAdapter :
    ListAdapter<UserModel, EarningListItemViewHolder>(EarningListDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = EarningListItemViewHolder(
        ItemEarningBinding.inflate(
            parent.context.inflater,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: EarningListItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class EarningListItemViewHolder(
        private val binding: ItemEarningBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: UserModel) = with(binding) {
            tvName.text = item.firstName
        }
    }

    object EarningListDiffCallback : DiffUtil.ItemCallback<UserModel>() {
        override fun areItemsTheSame(
            oldItem: UserModel,
            newItem: UserModel
        ): Boolean {
            return oldItem.firstName == newItem.firstName
        }

        override fun areContentsTheSame(
            oldItem: UserModel,
            newItem: UserModel
        ): Boolean {
            return oldItem == newItem
        }
    }
}