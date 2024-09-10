package com.alaingauthier1.iconvert.model

import com.alaingauthier1.iconvert.RatesItem
import com.alaingauthier1.iconvert.SymbolItem

interface RatesRepository {
    fun getRates(symbols: List<SymbolItem>): List<RatesItem>
    fun getAvailableSymbols(): List<SymbolItem>
}