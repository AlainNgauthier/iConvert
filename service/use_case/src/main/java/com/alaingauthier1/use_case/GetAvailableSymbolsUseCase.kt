package com.alaingauthier1.use_case

import com.alaingauthier1.common.model.SymbolItem
import com.alaingauthier1.rates_repository.RatesRepository
import javax.inject.Inject

class GetAvailableSymbolsUseCase @Inject constructor(
    private val ratesRepository: RatesRepository
) {
    fun getAvailableSymbols(): List<SymbolItem> =
        ratesRepository.getAvailableSymbols()
}