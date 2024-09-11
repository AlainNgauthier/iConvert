package com.alaingauthier1.use_case

import com.alaingauthier1.common.model.SymbolItem
import com.alaingauthier1.user_settings.UserSettings
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