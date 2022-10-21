package com.esrakaya.earningapp.data.service

import com.esrakaya.earningapp.data.model.EarningResponse
import retrofit2.http.GET

interface EarningService {

    @GET(".")
    suspend fun getEarningList(): EarningResponse
}