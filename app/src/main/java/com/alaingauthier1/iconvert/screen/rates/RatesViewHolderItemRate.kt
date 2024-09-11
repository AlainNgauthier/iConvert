package com.alaingauthier1.iconvert.screen.rates

import com.alaingauthier1.common.model.RatesItem
import com.alaingauthier1.iconvert.databinding.RatesListItemBinding

class RatesViewHolderItemRate(
    binding: RatesListItemBinding
): RatesViewHolderBase<RatesListItemBinding>(binding) {
    fun bind(item: RatesItem) {
        with(binding) {
            textSymbol.text = item.symbolCode
            textRate.text = item.rateValue

        }
    }
}