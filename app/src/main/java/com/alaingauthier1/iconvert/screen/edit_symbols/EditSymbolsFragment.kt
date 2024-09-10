package com.alaingauthier1.iconvert.screen.edit_symbols

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
import com.alaingauthier1.iconvert.databinding.FragmentEditSymbolsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EditSymbolsFragment : Fragment() {

    private val viewModel: EditSymbolsViewModel by viewModels()
    private var _binding: FragmentEditSymbolsBinding? = null
    private val binding: FragmentEditSymbolsBinding
        get() = _binding!!

    private val symbolsAdapter: EditSymbolsAdapter = EditSymbolsAdapter { symbolCode, isChecked ->
        viewModel.updateSelectedSymbols(symbolCode, isChecked)
    }

    init {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                with(viewModel) {
                    selectedSymbols.collect {
                        symbolsAdapter.setData(it.availableSymbols, it.selectedSymbols)
                    }
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditSymbolsBinding.inflate(inflater, container, false)
        with(binding.recyclerAllSymbols) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = symbolsAdapter
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchSelectedSymbols()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}