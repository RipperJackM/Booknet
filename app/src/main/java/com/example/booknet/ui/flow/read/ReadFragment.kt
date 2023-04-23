package com.example.booknet.ui.flow.read

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.booknet.databinding.FragmentReadBinding
import com.example.booknet.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ReadFragment : BaseFragment() {

    private var _binding: FragmentReadBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ReadViewModel by viewModel()
    private val args: ReadFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (_binding != null) return binding.root
        _binding = FragmentReadBinding.inflate(layoutInflater)
        viewModel.getBookChapters(args.bookId)
        setupViews()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        setupObservers()
    }

    private fun setupViews() = with(binding) {
        viewModel = this@ReadFragment.viewModel
    }

    private fun setupObservers() {
        viewModel.uiState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is ReadViewModel.UiState.Failure -> {
                    onFailure(state.error)
                    popBackStack()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.lifecycleOwner = null
    }
}