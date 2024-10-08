package com.alaingauthier1.rates_repository_impl

import com.alaingauthier1.common.model.RatesItem
import com.alaingauthier1.common.model.SymbolItem
import com.alaingauthier1.rates_repository.RatesApiService
import com.alaingauthier1.rates_repository.RatesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

// Inject: tell to Hilt to provide an instance of rates repository whenever its required
@Singleton
class RatesRepositoryImpl @Inject constructor(
    private val ratesApiService: RatesApiService
) : RatesRepository {
    private val availableSymbolsCache = mutableListOf<SymbolItem>()
    private val mutex = Mutex()

    override suspend fun getRates(
        base: SymbolItem?,
        amount: Double?,
        symbols: List<SymbolItem>?
    ): List<RatesItem> = withContext(Dispatchers.IO) {
        ratesApiService.getRates(
            base = base,
            amount = amount,
            symbols = symbols
        )
    }

//    override fun getRates(symbols: List<SymbolItem>): List<RatesItem> {
//        return data.filter { symbols.any { symbol -> symbol.code == it.symbolCode } }
//    }

    override suspend fun getAvailableSymbols() :List<SymbolItem> =
        withContext(Dispatchers.IO) {
            if(availableSymbolsCache.isEmpty()) {
                mutex.withLock {
                    if (availableSymbolsCache.isEmpty()) {
                        availableSymbolsCache.clear()
                        availableSymbolsCache.addAll(ratesApiService.getSymbols())
                    }
                }
            }
            availableSymbolsCache
        }

    override suspend fun getSymbolItemByCode(code: String): SymbolItem? =
        getAvailableSymbols().firstOrNull { it.code == code }

//    private fun generateMockRates(): List<RatesItem>{
//        return (0 until 5).map {
//            RatesItem(
//                symbolCode = generateMockSymbolCode(),
//                rateValue = String.format(
//                    "%.4f",
//                    Random.nextInt(from = 10000, until = 99999) / 10000f
//                )
//            )
//        }
//    }

//    private fun generateMockSymbolCode(): String{
//        return (0 until 3).map{ Random.nextInt( from = 65, until = 98).toChar() }.joinToString(separator = "")
//    }
}