package com.alaingauthier1.use_case

import com.alaingauthier1.common.model.SymbolItem
import com.alaingauthier1.user_settings.UserSettings
import javax.inject.Inject

class SelectedSymbolsUseCase @Inject constructor (
    private val userSettings: UserSettings
) {
    suspend fun getSelectedSymbols(): List<SymbolItem> =
        userSettings.getSelectedSymbols()

    suspend fun updateSelectedSymbols(symbols: List<SymbolItem>) {
        userSettings.setSelectedSymbols(symbols)
    }
}