package com.alaingauthier1.iconvert

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.alaingauthier1.iconvert.databinding.RatesListItemBinding

class RatesViewHolder(
    private val binding: RatesListItemBinding
): ViewHolder(binding.root) {
    fun bind(item: RatesItem) {
        with(binding) {
            textSymbol.text = item.symbolCode
            textRate.text = item.rateValue

        }
    }
}