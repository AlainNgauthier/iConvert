package com.alaingauthier1.iconvert

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.alaingauthier1.iconvert.databinding.FragmentRatesBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.Locale
import kotlin.random.Random

@AndroidEntryPoint
class RatesFragment : Fragment() {

    private lateinit var binding: FragmentRatesBinding
    private val ratesAdapter = RatesListAdapter()
    private val viewModel: RatesViewModel by viewModels()

    init {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.rates.collect {
                    rates -> ratesAdapter.updateList(rates)
                }
            }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRatesBinding.inflate(inflater, null, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getRates()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.recyclerRates) {
            layoutManager = LinearLayoutManager(context)
            adapter = ratesAdapter
        }
    }
}