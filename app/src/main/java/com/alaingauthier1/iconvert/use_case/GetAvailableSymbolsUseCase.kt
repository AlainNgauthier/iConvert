package com.alaingauthier1.iconvert.use_case

import com.alaingauthier1.iconvert.SymbolItem
import com.alaingauthier1.iconvert.model.RatesRepository
import javax.inject.Inject

class GetAvailableSymbolsUseCase @Inject constructor(
    private val ratesRepository: RatesRepository
) {
    fun getAvailableSymbols(): List<SymbolItem> =
        ratesRepository.getAvailableSymbols()
}