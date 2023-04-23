package com.example.booknet.ui.flow.archive

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.booknet.R
import com.example.booknet.databinding.FragmentArchiveBinding
import com.example.booknet.datasource.library.LibraryDataSource
import com.example.booknet.datasource.library.LibraryType
import com.example.booknet.ui.base.BaseBottomNavigationFragment
import com.example.booknet.ui.base.recycler.BookMultiValuesRecyclerAdapter
import com.example.booknet.ui.flow.library.LibraryItemViewData

class ArchiveFragment: BaseBottomNavigationFragment() {

    private var _binding: FragmentArchiveBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentArchiveBinding.inflate(layoutInflater)
        setupViews()
        return binding.root
    }

    private fun setupViews() = with(binding) {
        rvBooks.adapter = BookMultiValuesRecyclerAdapter(
            LibraryDataSource.getBooksByType(LibraryType.LIBRARY_TYPE_ARCHIVE).map { LibraryItemViewData(it) }
        )

        llEmpty.isVisible = (rvBooks.adapter as BookMultiValuesRecyclerAdapter).list.isEmpty()
        btnGoToLibrary.setOnClickListener { navigate(R.id.nav_library) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}