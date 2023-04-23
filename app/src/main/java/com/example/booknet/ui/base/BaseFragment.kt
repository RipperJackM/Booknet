package com.example.booknet.ui.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.Navigator
import androidx.navigation.fragment.findNavController
import com.example.booknet.MainActivity

open class BaseFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        BottomNavigationHandler.isNeedToShow(false)
    }

    fun popBackStack() {
        findNavController().popBackStack()
    }

    fun navigate(directions: NavDirections) {
        findNavController().navigate(directions)
    }

    fun navigate(id: Int) {
        findNavController().navigate(id)
    }

    fun navigate(directions: NavDirections, navigatorExtras: Navigator.Extras) {
        findNavController().navigate(directions, navigatorExtras)
    }

    open fun onBackPressed() {
        findNavController().popBackStack()
    }

    fun onFailure(error: String) {
        (requireActivity() as MainActivity).showError(error)
    }
}