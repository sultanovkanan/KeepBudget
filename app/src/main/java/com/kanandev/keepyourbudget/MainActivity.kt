package com.kanandev.keepyourbudget

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.kanandev.keepyourbudget.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavController()
        setupWindowInsets()
    }

    private fun setupNavController() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { _, destination, _ ->
            val authDestinations = setOf(
                com.kanandev.feature_auth.R.id.introDemoFragment
            )

            val isVisible = destination.id !in authDestinations
            binding.bottomNav.isVisible = isVisible

            if (isVisible) setupBottomNavigation()
        }
    }

    private fun setupWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun setupBottomNavigation() {
        val navGraphIds = listOf(
            com.kanandev.feature_home.R.navigation.transaction_navigation,
            com.kanandev.feature_statistic.R.navigation.statistic_navigation,
            com.kanandev.feature_settings.R.navigation.settings_navigation
        )

        binding.bottomNav.setupWithNavController(
            navGraphIds,
            supportFragmentManager,
            R.id.nav_host_fragment,
            intent
        )
    }
}

