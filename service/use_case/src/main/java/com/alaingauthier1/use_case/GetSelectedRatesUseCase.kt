package com.alaingauthier1.use_case

import com.alaingauthier1.common.model.RatesItem
import com.alaingauthier1.common.model.SymbolItem
import com.alaingauthier1.user_settings.UserSettings
import com.alaingauthier1.rates_repository.RatesRepository
import javax.inject.Inject

class GetSelectedRatesUseCase @Inject constructor(
    private val repository: RatesRepository,
    private val userSettings: UserSettings
) {
    suspend fun getRates(base: SymbolItem, amount: Double): List<RatesItem> {
        return repository.getRates(
            base = base,
            amount = amount,
            symbols = userSettings.getSelectedSymbols()
        )
    }
}