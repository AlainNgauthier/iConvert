package com.alaingauthier1.iconvert.model

import com.alaingauthier1.iconvert.RatesItem
import javax.inject.Inject
import kotlin.random.Random

// Inject: tell to Hilt to provide an instance of rates repository whenever its required
class RatesRepository @Inject constructor() {

    fun getRates(): List<RatesItem> {
        return generateMockRates()
    }

    private fun generateMockRates(): List<RatesItem>{
        return (0 until 10).map {
            RatesItem(
                symbolCode = generateMockSymbolCode(),
                rateValue = String.format("%.4f", Random.nextInt(from = 10000, until = 99999) / 10000f)
            )
        }
    }

    private fun generateMockSymbolCode(): String{
        return (0 until 5).map{ Random.nextInt( from = 65, until = 98).toChar() }.joinToString(separator = "")
    }
}