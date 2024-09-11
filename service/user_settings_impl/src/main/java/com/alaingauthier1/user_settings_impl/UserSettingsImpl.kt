package com.alaingauthier1.user_settings_impl

import android.content.Context
import android.content.SharedPreferences
import com.alaingauthier1.common.model.SymbolItem
import com.alaingauthier1.rates_repository.RatesRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import androidx.core.content.edit

@Singleton
class UserSettingsImpl @Inject constructor(
    @ApplicationContext context: Context,
    private val ratesRepository: RatesRepository
) : com.alaingauthier1.user_settings.UserSettings {
    private val prefs: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    private val selectedSymbols: MutableList<SymbolItem> = mutableListOf()
    private val mutex = Mutex()

    override suspend fun getSelectedSymbols(): List<SymbolItem> {
        if (selectedSymbols.isEmpty()) {
            mutex.withLock {
                if (selectedSymbols.isEmpty()) {
                    selectedSymbols.addAll(readSelectedSymbolsFromPrefs())
                }
            }
        }
        return selectedSymbols.toList()
    }

    override suspend fun setSelectedSymbols(symbols: List<SymbolItem>) {
        with(selectedSymbols) {
            clear()
            addAll(symbols)
        }
        saveSelectedSymbolsToPrefs(selectedSymbols)
    }

    private suspend fun readSelectedSymbolsFromPrefs(): List<SymbolItem> =
        withContext(Dispatchers.IO) {
            prefs.getStringSet(KEY_SELECTED_SYMBOLS, null)
                .orEmpty()
                .mapNotNull { ratesRepository.getSymbolItemByCode(it) }
        }

    private suspend fun saveSelectedSymbolsToPrefs(symbols: List<SymbolItem>) =
        withContext(Dispatchers.IO) {
            prefs.edit (commit = true) {
                putStringSet(KEY_SELECTED_SYMBOLS, symbols.map { it.code }.toSet())
            }
        }

    companion object {
        private const val PREFS_NAME = "user_settings_prefs"
        private const val KEY_SELECTED_SYMBOLS = "key_selected_symbols"
    }
}