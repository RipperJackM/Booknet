package com.example.booknet.ui.flow.home.iread

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.booknet.databinding.FragmentIReadBinding
import com.example.booknet.ui.base.BaseBottomNavigationFragment
import com.example.booknet.ui.flow.home.library.LibraryFragmentDirections
import com.example.booknet.ui.flow.home.router.HomeRouter
import com.example.booknet.ui.flow.home.router.HomeRouterAction
import com.example.booknet.ui.flow.home.router.HomeRouterListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class IReadFragment : BaseBottomNavigationFragment(), HomeRouterListener {

    private var _binding: FragmentIReadBinding? = null
    private val binding get() = _binding!!

    private val viewModel: IReadViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIReadBinding.inflate(layoutInflater)
        setupViews()
        return binding.root
    }

    private fun setupViews() = with(binding) {
        viewModel = this@IReadFragment.viewModel
        lifecycleOwner = this@IReadFragment.viewLifecycleOwner
        btnGoToLibrary.setOnClickListener { onBackPressed() }
    }

    override fun navigate(action: HomeRouterAction) {
        when (action) {
            is HomeRouterAction.ShowReadFragment ->
                navigate(IReadFragmentDirections.navigateToRead(action.book.id.toString()))
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