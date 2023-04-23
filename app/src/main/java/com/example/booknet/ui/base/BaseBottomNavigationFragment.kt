package com.example.booknet.ui.base

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.booknet.MainActivity
import com.example.booknet.R
import com.example.booknet.ui.flow.favorites.FavouritesFragment
import com.example.booknet.ui.flow.library.LibraryFragment

open class BaseBottomNavigationFragment : BaseFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        BottomNavigationHandler.isNeedToShow(true)
    }

    override fun onBackPressed() {
        if (this is LibraryFragment) (requireActivity() as MainActivity).finish()
        else findNavController().popBackStack(R.id.nav_library, false)
    }
}