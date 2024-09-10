package com.alaingauthier1.iconvert.screen.rates

import com.alaingauthier1.iconvert.databinding.RatesListAddItemBinding

class RatesViewHolderAddItem(
    binding: RatesListAddItemBinding,
) : RatesViewHolderBase<RatesListAddItemBinding>(binding) {

    fun bind(onClick: () -> Unit) {
        binding.btnAddRatesItem.setOnClickListener {
            onClick()
        }
    }
}