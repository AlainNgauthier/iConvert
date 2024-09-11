package com.alaingauthier1.rates_repository.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class TimeseriesResponse(
    val amount: Double,
    val base: String,
    @kotlinx.serialization.Serializable(with = DataSerializer::class)
    @SerialName("start_date")
    val startDate: LocalDate,
    @Serializable(with = DataSerializer::class)
    @SerialName("end_date")
    val endDate: LocalDate,
    val rates: Map<@Serializable(with = DataSerializer::class) LocalDate, Map<String, Double>>
)
