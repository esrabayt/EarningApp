package com.esrakaya.earningapp.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.esrakaya.earningapp.R
import com.esrakaya.earningapp.databinding.FragmentEarningListBinding
import com.esrakaya.earningapp.utils.collectEvent
import com.esrakaya.earningapp.utils.collectState
import com.esrakaya.earningapp.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EarningListFragment : Fragment() {

    private val binding by viewBinding(FragmentEarningListBinding::bind)

    private val viewModel: EarningListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_earning_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        collectState(viewModel.uiState, ::renderView)
        collectEvent(viewModel.uiEvent, ::handleEvent)
    }


    private fun initView() = with(binding) {

    }

    private fun renderView(uiState: EarningListUiState) = with(binding) {

    }

    private fun handleEvent(uiEvent: EarningListUiEvent) {
        when (uiEvent) {
            else -> Unit
        }
    }
}
