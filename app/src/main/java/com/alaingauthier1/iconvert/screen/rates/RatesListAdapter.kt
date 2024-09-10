package com.alaingauthier1.iconvert.screen.rates

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.viewbinding.ViewBinding
import com.alaingauthier1.iconvert.RatesItem
import com.alaingauthier1.iconvert.databinding.RatesListAddItemBinding
import com.alaingauthier1.iconvert.databinding.RatesListItemBinding

class RatesListAdapter(
    private val onAddCurrency: () -> Unit
): Adapter<RatesViewHolderBase<*>>() {
    private val ratesList = mutableListOf<RatesItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatesViewHolderBase<*> {
        return  when (viewType) {
            ITEM_TYPE_RATES -> RatesViewHolderItemRate(
                RatesListItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> RatesViewHolderAddItem(
                RatesListAddItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position in ratesList.indices) ITEM_TYPE_RATES else ITEM_TYPE_ADD
    }

    override fun getItemCount(): Int = ratesList.size + 1

    override fun onBindViewHolder(holder: RatesViewHolderBase<*>, position: Int) {
        when (holder) {
            is RatesViewHolderItemRate -> ratesList.getOrNull(position)?.let { holder.bind(it) }
            is RatesViewHolderAddItem -> holder.bind(onAddCurrency)
        }
    }

    fun updateList(data: List<RatesItem>) {
        ratesList.clear()
        ratesList.addAll(data)
        notifyDataSetChanged()
    }

    companion object {
        const val ITEM_TYPE_RATES = 10
        const val ITEM_TYPE_ADD = 20
    }
}

abstract class RatesViewHolderBase<VB : ViewBinding>(
    protected val binding: VB
) : RecyclerView.ViewHolder(binding.root)