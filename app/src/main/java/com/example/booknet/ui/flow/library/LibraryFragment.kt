package com.example.booknet.ui.flow.library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.booknet.databinding.FragmentLibraryBinding
import com.example.booknet.ui.base.BaseFragment

class LibraryFragment : BaseFragment() {

    private var _binding: FragmentLibraryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (_binding != null) return binding.root
        _binding = FragmentLibraryBinding.inflate(layoutInflater)
        setupViews()
        return binding.root
    }

    private fun setupViews() {

    }
}