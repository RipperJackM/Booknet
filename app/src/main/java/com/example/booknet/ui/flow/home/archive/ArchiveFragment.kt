package com.example.booknet.ui.flow.home.archive

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.booknet.databinding.FragmentArchiveBinding
import com.example.booknet.ui.base.BaseBottomNavigationFragment
import com.example.booknet.ui.flow.home.router.HomeRouter
import com.example.booknet.ui.flow.home.router.HomeRouterAction
import com.example.booknet.ui.flow.home.router.HomeRouterListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class ArchiveFragment : BaseBottomNavigationFragment(), HomeRouterListener {

    private var _binding: FragmentArchiveBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ArchiveViewModel by viewModel()

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
        viewModel = this@ArchiveFragment.viewModel
        lifecycleOwner = this@ArchiveFragment.viewLifecycleOwner
        btnGoToLibrary.setOnClickListener { onBackPressed() }
    }

    override fun navigate(action: HomeRouterAction) {
        when (action) {
            is HomeRouterAction.ShowReadFragment -> return
        }
    }

    override fun onResume() {
        super.onResume()
        HomeRouter.listener = this
    }

    override fun onPause() {
        super.onPause()
        HomeRouter.listener = null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}