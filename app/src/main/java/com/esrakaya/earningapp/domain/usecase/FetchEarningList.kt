package com.esrakaya.earningapp.domain.usecase

import com.esrakaya.earningapp.data.repository.EarningRepository
import com.esrakaya.earningapp.domain.mapper.EarningMapper
import com.esrakaya.earningapp.domain.model.EarningModel
import com.esrakaya.earningapp.domain.utils.mapWith
import javax.inject.Inject

class FetchEarningList @Inject constructor(
    private val earningRepository: EarningRepository,
    private val earningMapper: EarningMapper
) {

    suspend operator fun invoke(): EarningModel {
        val response = earningRepository.getEarningList()
        return response.mapWith(earningMapper)
    }
}