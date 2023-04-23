package com.example.booknet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.booknet.databinding.ActivityMainBinding
import com.example.booknet.ui.base.BaseFragment
import com.example.booknet.ui.base.BottomNavigationHandler
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
    }

    override fun onResume() {
        super.onResume()
        setupObservers()
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val fragment = getCurrentFragment()
        if (fragment is BaseFragment) {
            fragment.onBackPressed()
        }
    }

    fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    private fun setupViews() = with(binding) {
        bottomNavigation.setupWithNavController(findNavController(R.id.nav_host_fragment_activity_main))
        bottomNavigation.setOnItemSelectedListener { item ->
            try {
                NavigationUI.onNavDestinationSelected(item, findNavController(R.id.nav_host_fragment_activity_main))
                findNavController(R.id.nav_host_fragment_activity_main).popBackStack(item.itemId, inclusive = false)
                true
            } catch (e: Exception) {
                true
            }
        }
    }

    private fun setupObservers() {
        BottomNavigationHandler.isVisible.observe(this) { binding.bottomNavigation.isVisible = it }
    }

    private fun getCurrentFragment(): Fragment? {
        val navHostFragment: NavHostFragment? =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment?
        return navHostFragment?.childFragmentManager?.fragments?.get(0)
    }
}