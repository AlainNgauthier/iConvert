package com.alaingauthier1.iconvert

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserSettingsImpl @Inject constructor(): UserSettings {
    private val selectedSymbols: MutableList<SymbolItem> = mutableListOf()

    override fun getSelectedSymbols(): List<SymbolItem> = selectedSymbols.toList()

    override fun setSelectedSymbols(symbols: List<SymbolItem>) {
        with(selectedSymbols) {
            clear()
            addAll(symbols)
        }
    }
}