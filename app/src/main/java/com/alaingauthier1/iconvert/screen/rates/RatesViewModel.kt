package com.alaingauthier1.iconvert.screen.rates

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alaingauthier1.common.model.RatesItem
import com.alaingauthier1.common.model.SymbolItem
import com.alaingauthier1.use_case.GetSelectedRatesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RatesViewModel @Inject constructor(
    private val getRatesUseCase: GetSelectedRatesUseCase
): ViewModel() {

    private val _rates: MutableStateFlow<List<RatesItem>> = MutableStateFlow(emptyList())
    val rates: StateFlow<List<RatesItem>> = _rates.asStateFlow()

    // API function to fetch rates
    fun getRates(base: SymbolItem, amount: Double) {
        viewModelScope.launch {
            _rates.tryEmit(
                getRatesUseCase.getRates(base = base, amount = amount)
            )
        }
    }
}