package com.alaingauthier1.iconvert.screen.edit_symbols

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alaingauthier1.iconvert.SymbolItem
import com.alaingauthier1.iconvert.databinding.EditSymbolsItemsViewBinding

class EditSymbolsAdapter (
    private val onItemClicked: (String, Boolean) -> Unit
): RecyclerView.Adapter<EditSymbolsViewHolder>() {
    private val allSymbols: MutableList<SymbolItem> = mutableListOf()
    private val selectedSymbols: MutableList<SymbolItem> = mutableListOf()
    private val selectedSymbolsMap: MutableMap<SymbolItem, Boolean> = mutableMapOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EditSymbolsViewHolder {
        return EditSymbolsViewHolder(
            EditSymbolsItemsViewBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = allSymbols.size

    override fun onBindViewHolder(holder: EditSymbolsViewHolder, position: Int) {
        val symbol = allSymbols[position]
        selectedSymbolsMap[symbol]?.let { isSelected ->
            holder.bind(symbol, isSelected) { code, isChecked ->
                onItemSelected(code, isChecked)
            }
        }
    }

    fun setData(allSymbols: List<SymbolItem>, selectedSymbols: List<SymbolItem>) {
        with(this.allSymbols) {
            clear()
            addAll(allSymbols)
        }
        with(this.selectedSymbols) {
            clear()
            addAll(selectedSymbols)
        }
        recalculateSelected()
        notifyItemRangeChanged(0, allSymbols.size)
    }

    private fun onItemSelected(code: String, selected: Boolean) {
        onItemClicked(code, selected)

        val checkedSymbol = SymbolItem(code)
        if (selected) {
            selectedSymbols.add(checkedSymbol)
        } else {
            selectedSymbols.remove(checkedSymbol)
        }
        recalculateSelected()
    }

    private fun recalculateSelected() {
        with(selectedSymbolsMap) {
            clear()
            putAll(
                allSymbols.map { it to (it in selectedSymbols) }
            )
        }
    }
}