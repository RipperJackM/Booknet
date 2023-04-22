package com.example.booknet.ui.base

import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.Navigator
import androidx.navigation.fragment.findNavController

open class BaseFragment : Fragment() {

    fun popBackStack() {
        findNavController().popBackStack()
    }

    fun navigate(directions: NavDirections) {
        findNavController().navigate(directions)
    }

    fun navigate(directions: NavDirections, navigatorExtras: Navigator.Extras) {
        findNavController().navigate(directions, navigatorExtras)
    }

    open fun onBackPressed() {
        findNavController().popBackStack()
    }

    fun onFailure(error: String) {

    }
}