package com.esrakaya.earningapp.data.repository

import com.esrakaya.earningapp.data.exception.HandleException
import com.esrakaya.earningapp.data.model.EarningResponse
import com.esrakaya.earningapp.data.service.EarningService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CommonRepository @Inject constructor(
    private val earningService: EarningService,
    private val handleException: HandleException
) {

    suspend fun getEarningList(): EarningResponse {
        return runCatching {
            earningService.getEarningList()
        }.getOrElse { throw handleException(it) }
    }
}