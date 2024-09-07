package com.alaingauthier1.iconvert

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.alaingauthier1.iconvert.databinding.RatesListItemBinding

class RatesListAdapter: Adapter<RatesViewHolder>() {
    private val ratesList = mutableListOf<RatesItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatesViewHolder {
        return RatesViewHolder(
            RatesListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = ratesList.size

    override fun onBindViewHolder(holder: RatesViewHolder, position: Int) {
        ratesList.getOrNull(position)?.let{holder.bind(it)}
    }

    fun updateList(data: List<RatesItem>) {}
}