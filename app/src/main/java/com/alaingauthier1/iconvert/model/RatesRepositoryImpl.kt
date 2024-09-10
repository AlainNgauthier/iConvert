package com.alaingauthier1.iconvert.model

import com.alaingauthier1.iconvert.RatesItem
import com.alaingauthier1.iconvert.SymbolItem
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

// Inject: tell to Hilt to provide an instance of rates repository whenever its required
@Singleton
class RatesRepositoryImpl @Inject constructor() : RatesRepository {
    private val data = generateMockRates()

    override fun getRates(symbols: List<SymbolItem>): List<RatesItem> {
        return data.filter { symbols.any { symbol -> symbol.code == it.symbolCode } }
    }

    override fun getAvailableSymbols() :List<SymbolItem> =
        data.map { SymbolItem(it.symbolCode) }

    private fun generateMockRates(): List<RatesItem>{
        return (0 until 10).map {
            RatesItem(
                symbolCode = generateMockSymbolCode(),
                rateValue = String.format("%.4f", Random.nextInt(from = 10000, until = 99999) / 10000f)
            )
        }
    }

    private fun generateMockSymbolCode(): String{
        return (0 until 3).map{ Random.nextInt( from = 65, until = 98).toChar() }.joinToString(separator = "")
    }
}