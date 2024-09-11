package com.alaingauthier1.iconvert.screen.edit_symbols

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alaingauthier1.common.model.SymbolItem
import com.alaingauthier1.use_case.GetAvailableSymbolsUseCase
import com.alaingauthier1.use_case.SelectedSymbolsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditSymbolsViewModel @Inject constructor(
    private val getAvailableSymbolsUseCase: GetAvailableSymbolsUseCase,
    private val selectedSymbolsUseCase: SelectedSymbolsUseCase
) : ViewModel() {
    // TODO: Implement the ViewModel
    private val _selectedSymbols: MutableStateFlow<SelectedSymbols> =
        MutableStateFlow(SelectedSymbols(emptyList(), emptyList()))
    val selectedSymbols: StateFlow<SelectedSymbols> = _selectedSymbols.asStateFlow()

    fun fetchSelectedSymbols() {
        viewModelScope.launch(Dispatchers.IO) {
            _selectedSymbols.emit(
                SelectedSymbols(
                    selectedSymbolsUseCase.getSelectedSymbols(),
                    getAvailableSymbolsUseCase.getAvailableSymbols()
                )
            )
        }
    }

    fun updateSelectedSymbols(code: String, isChecked: Boolean) {
        val selectedSymbols = selectedSymbolsUseCase.getSelectedSymbols()
        if (isChecked) {
            // adding a symbol
            selectedSymbolsUseCase.updateSelectedSymbols(selectedSymbols.plus(SymbolItem(code)))
        } else {
            // removing a symbol
            selectedSymbolsUseCase.updateSelectedSymbols(selectedSymbols.filter { it.code != code })
        }
    }

    data class SelectedSymbols(
        val selectedSymbols: List<SymbolItem>,
        val availableSymbols: List<SymbolItem>,
    )
}