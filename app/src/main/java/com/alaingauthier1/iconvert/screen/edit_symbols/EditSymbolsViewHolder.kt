package com.alaingauthier1.iconvert.screen.edit_symbols

import androidx.recyclerview.widget.RecyclerView
import com.alaingauthier1.iconvert.SymbolItem
import com.alaingauthier1.iconvert.databinding.EditSymbolsItemsViewBinding

class EditSymbolsViewHolder(
    private val binding: EditSymbolsItemsViewBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: SymbolItem, selected: Boolean, onClicked: (String, Boolean) -> Unit) {
        with(binding) {
            textSymbolCode.text = item.code
            checkBoxSelectedSymbol.setOnCheckedChangeListener(null)
            checkBoxSelectedSymbol.isChecked = selected
            checkBoxSelectedSymbol.setOnCheckedChangeListener { _, isChecked ->
                onClicked(item.code, isChecked)
            }
        }
    }
}