package com.example.booknet.ui.flow.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.booknet.databinding.FragmentStartBinding
import com.example.booknet.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent

class StartFragment : BaseFragment(), KoinComponent {

    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!

    private val viewModel: StartViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartBinding.inflate(layoutInflater)
        getDestination()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    private fun getDestination() {
        if (viewModel.isUserAuthorized()) viewModel.getLibraryData()
        else viewModel.getUserCredentials(requireContext()) // In normal solution in this case we go to sign in fragment
    }

    private fun setupObservers() {
        viewModel.uiState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is StartViewModel.UiState.OnGetUserCredentials -> viewModel.getLibraryData()
                is StartViewModel.UiState.OnGetLibraryData -> navigate(StartFragmentDirections.navigateToLibrary())
                is StartViewModel.UiState.Failure -> onFailure(state.error)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        viewModel.uiState.removeObservers(viewLifecycleOwner)
    }
}