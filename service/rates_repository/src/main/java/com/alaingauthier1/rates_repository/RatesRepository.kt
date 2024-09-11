package com.alaingauthier1.rates_repository

import com.alaingauthier1.common.model.RatesItem
import com.alaingauthier1.common.model.SymbolItem

interface RatesRepository {
    fun getRates(symbols: List<SymbolItem>): List<RatesItem>
    fun getAvailableSymbols(): List<SymbolItem>
}