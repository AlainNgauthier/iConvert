package com.alaingauthier1.iconvert.use_case

import com.alaingauthier1.iconvert.SymbolItem
import com.alaingauthier1.iconvert.UserSettings
import javax.inject.Inject

class SelectedSymbolsUseCase @Inject constructor (
    private val userSettings: UserSettings
) {
    fun getSelectedSymbols(): List<SymbolItem> =
        userSettings.getSelectedSymbols()

    fun updateSelectedSymbols(symbols: List<SymbolItem>) {
        userSettings.setSelectedSymbols(symbols)
    }
}