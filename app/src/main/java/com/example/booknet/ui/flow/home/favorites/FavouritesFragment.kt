package com.example.booknet.ui.flow.home.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.booknet.databinding.FragmentFavouritesBinding
import com.example.booknet.ui.base.BaseBottomNavigationFragment
import com.example.booknet.ui.flow.home.library.LibraryFragmentDirections
import com.example.booknet.ui.flow.home.router.HomeRouter
import com.example.booknet.ui.flow.home.router.HomeRouterAction
import com.example.booknet.ui.flow.home.router.HomeRouterListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavouritesFragment : BaseBottomNavigationFragment(), HomeRouterListener {

    private var _binding: FragmentFavouritesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FavouritesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavouritesBinding.inflate(layoutInflater)
        setupViews()
        return binding.root
    }

    private fun setupViews() = with(binding) {
        viewModel = this@FavouritesFragment.viewModel
        lifecycleOwner = this@FavouritesFragment.viewLifecycleOwner
        btnGoToLibrary.setOnClickListener { onBackPressed() }
    }

    override fun navigate(action: HomeRouterAction) {
        when (action) {
            is HomeRouterAction.ShowReadFragment ->
                navigate(FavouritesFragmentDirections.navigateToRead(action.book.id.toString()))
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