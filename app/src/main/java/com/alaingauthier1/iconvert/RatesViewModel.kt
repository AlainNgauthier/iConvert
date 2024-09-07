package com.alaingauthier1.iconvert

import androidx.lifecycle.ViewModel
import com.alaingauthier1.iconvert.use_case.GetRatesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RatesViewModel(): ViewModel() {
    private val getRatesUseCase: GetRatesUseCase = GetRatesUseCase()
    private val _rates: MutableStateFlow<List<RatesItem>> = MutableStateFlow(emptyList())
    val rates: StateFlow<List<RatesItem>> = _rates.asStateFlow()

    // API function to fetch rates
    fun getRates() {
        _rates.tryEmit(getRatesUseCase.getRates())
    }
}