package com.alaingauthier1.iconvert.use_case

import com.alaingauthier1.iconvert.RatesItem
import com.alaingauthier1.iconvert.UserSettings
import com.alaingauthier1.iconvert.model.RatesRepository
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