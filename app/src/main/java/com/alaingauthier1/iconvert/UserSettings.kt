package com.alaingauthier1.iconvert

import javax.inject.Inject
import javax.inject.Singleton

interface UserSettings {
    fun getSelectedSymbols(): List<SymbolItem>
    fun setSelectedSymbols(symbols: List<SymbolItem>)
}