package com.alaingauthier1.use_case

import com.alaingauthier1.common.model.RatesItem
import com.alaingauthier1.user_settings.UserSettings
import com.alaingauthier1.rates_repository.RatesRepository
import javax.inject.Inject

class GetSelectedRatesUseCase @Inject constructor(
    private val repository: RatesRepository,
    private val userSettings: UserSettings
) {
    fun getRates(): List<RatesItem> {
        return repository.getRates(
            userSettings.getSelectedSymbols()
        )
    }
}