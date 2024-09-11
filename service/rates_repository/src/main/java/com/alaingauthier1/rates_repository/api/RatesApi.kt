package com.alaingauthier1.rates_repository.api

import com.alaingauthier1.rates_repository.model.LatestResponse
import com.alaingauthier1.rates_repository.model.TimeseriesResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.time.LocalDate

interface RatesApi {
    @GET("currencies")
    suspend fun getSymbols(): Response<Map<String, String>>

    @GET("latest")
    suspend fun getLatestRates(
        @Query("from") from: String? = null,
        @Query("to") to: String? = null,
        @Query("amount") amount: Float? = null,
    ): Response<LatestResponse>

    @GET("{start}..{end}")
    suspend fun getTimeseries(
        @Path(value="start") start: LocalDate,
        @Path(value = "end") end: LocalDate,
        @Query("from") from: String? = null,
        @Query("to") to: String? = null
    ): Response<TimeseriesResponse>
}