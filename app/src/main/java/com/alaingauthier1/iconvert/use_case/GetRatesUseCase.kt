package com.alaingauthier1.iconvert.use_case

import com.alaingauthier1.iconvert.RatesItem
import com.alaingauthier1.iconvert.model.RatesRepository

class GetRatesUseCase {
    private val repository = RatesRepository()

    fun getRates(): List<RatesItem> {
        return repository.getRates()
    }
}