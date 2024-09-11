package com.alaingauthier1.rates_repository_impl

import com.alaingauthier1.common.model.RatesItem
import com.alaingauthier1.common.model.SymbolItem
import com.alaingauthier1.rates_repository.RatesApiService
import com.alaingauthier1.rates_repository.api.RatesApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RatesApiServiceImpl @Inject constructor(
    private val api: RatesApi
) : RatesApiService {
    override suspend fun getRates(
        base: SymbolItem?,
        amount: Double?,
        symbols: List<SymbolItem>?
    ): List<RatesItem> =
        api.getLatestRates(
            from = base?.code,
            amount = amount?.toFloat(),
            to = symbols?.joinToString(separator = ",") { it.code }
        )
            .body()
            ?.rates
            ?.map { RatesItem(it.key, "${it.value}") } ?: emptyList()
}