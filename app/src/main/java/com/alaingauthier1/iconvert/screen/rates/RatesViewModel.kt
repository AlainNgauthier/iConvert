package com.alaingauthier1.iconvert.screen.rates

import androidx.lifecycle.ViewModel
import com.alaingauthier1.iconvert.RatesItem
import com.alaingauthier1.iconvert.use_case.GetSelectedRatesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class RatesViewModel @Inject constructor(
    private val getRatesUseCase: GetSelectedRatesUseCase
): ViewModel() {

    private val _rates: MutableStateFlow<List<RatesItem>> = MutableStateFlow(emptyList())
    val rates: StateFlow<List<RatesItem>> = _rates.asStateFlow()

    // API function to fetch rates
    fun getRates() {
        _rates.tryEmit(getRatesUseCase.getRates())
    }
}