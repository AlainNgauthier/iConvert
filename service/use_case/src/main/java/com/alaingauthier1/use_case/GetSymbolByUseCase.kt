package com.alaingauthier1.use_case

import com.alaingauthier1.common.model.SymbolItem
import com.alaingauthier1.rates_repository.RatesRepository
import javax.inject.Inject

class GetSymbolByUseCase  @Inject constructor(
    private val ratesRepository: RatesRepository
) {
    suspend fun getSymbolByCode(code: String): SymbolItem? =
        ratesRepository.getSymbolItemByCode(code)
}