package com.alaingauthier1.user_settings

import com.alaingauthier1.common.model.SymbolItem

interface UserSettings {
    suspend fun getSelectedSymbols(): List<SymbolItem>
    suspend fun setSelectedSymbols(symbols: List<SymbolItem>)
}