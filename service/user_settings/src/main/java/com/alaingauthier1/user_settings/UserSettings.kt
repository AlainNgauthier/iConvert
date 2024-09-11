package com.alaingauthier1.user_settings

import com.alaingauthier1.common.model.SymbolItem

interface UserSettings {
    fun getSelectedSymbols(): List<SymbolItem>
    fun setSelectedSymbols(symbols: List<SymbolItem>)
}