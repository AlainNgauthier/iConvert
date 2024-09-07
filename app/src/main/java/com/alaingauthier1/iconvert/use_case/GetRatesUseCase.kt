package com.alaingauthier1.iconvert.use_case

import com.alaingauthier1.iconvert.RatesItem
import com.alaingauthier1.iconvert.model.RatesRepository
import javax.inject.Inject

class GetRatesUseCase @Inject constructor(
    private val repository: RatesRepository
) {
    fun getRates(): List<RatesItem> {
        return repository.getRates()
    }
}