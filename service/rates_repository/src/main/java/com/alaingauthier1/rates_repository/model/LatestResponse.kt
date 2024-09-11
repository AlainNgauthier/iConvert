package com.alaingauthier1.rates_repository.model

import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class LatestResponse(val amount: Double,
                          val base: String,
                          @Serializable(with = DataSerializer::class)
                          val date: LocalDate,
                          val rates: Map<String, Double>
)
