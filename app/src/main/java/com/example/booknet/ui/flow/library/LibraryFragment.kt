package com.example.booknet.ui.flow.library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.booknet.databinding.FragmentLibraryBinding
import com.example.booknet.datasource.library.LibraryDataSource
import com.example.booknet.datasource.library.LibraryType
import com.example.booknet.ui.base.BaseBottomNavigationFragment
import com.example.booknet.ui.base.recycler.BookMultiValuesRecyclerAdapter

class LibraryFragment : BaseBottomNavigationFragment() {

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

    private fun setupViews() = with(binding) {
        rvBooks.adapter = BookMultiValuesRecyclerAdapter(
            LibraryDataSource.getBooksByType(LibraryType.LIBRARY_TYPE_GENERAL).map { LibraryItemViewData(it) }
        )

        llEmpty.isVisible = (rvBooks.adapter as BookMultiValuesRecyclerAdapter).list.isEmpty()
    }
}