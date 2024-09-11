package com.alaingauthier1.rates_repository

import com.alaingauthier1.common.model.RatesItem
import com.alaingauthier1.common.model.SymbolItem

interface RatesApiService {
    suspend fun getRates(
        base: SymbolItem?,
        amount: Double?,
        symbols: List<SymbolItem>?
    ): List<RatesItem>
}