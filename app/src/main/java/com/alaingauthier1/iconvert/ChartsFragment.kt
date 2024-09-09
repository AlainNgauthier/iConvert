package com.alaingauthier1.iconvert

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.alaingauthier1.iconvert.databinding.FragmentChartsBinding
import com.alaingauthier1.iconvert.databinding.FragmentRatesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChartsFragment : Fragment() {

    private var _binding: FragmentChartsBinding? = null
    private val binding: FragmentChartsBinding?
        get() = _binding!!
    private val viewModel: ChartsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChartsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}