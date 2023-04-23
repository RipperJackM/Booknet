package com.example.booknet.ui.flow.home.library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.booknet.databinding.FragmentLibraryBinding
import com.example.booknet.ui.base.BaseBottomNavigationFragment
import com.example.booknet.ui.flow.home.router.HomeRouter
import com.example.booknet.ui.flow.home.router.HomeRouterAction
import com.example.booknet.ui.flow.home.router.HomeRouterListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class LibraryFragment : BaseBottomNavigationFragment(), HomeRouterListener {

    private var _binding: FragmentLibraryBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LibraryViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (_binding != null) return binding.root
        _binding = FragmentLibraryBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
    }

    override fun navigate(action: HomeRouterAction) {
        when (action) {
            is HomeRouterAction.ShowReadFragment ->
                navigate(LibraryFragmentDirections.navigateToRead(action.book.id.toString()))
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
        binding.lifecycleOwner = null
    }
}