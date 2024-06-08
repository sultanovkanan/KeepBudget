package com.kanandev.keepyourbudget

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kanandev.keepyourbudget.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val navGraphIds = listOf(
            com.kanandev.feature_home.R.navigation.transaction_navigation,
            com.kanandev.feature_statistic.R.navigation.statistic_navigation,
            com.kanandev.feature_settings.R.navigation.settings_navigation
        )

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            binding.bottomNav.setupWithNavController(
                navGraphIds,
                supportFragmentManager,
                R.id.nav_host_fragment,
                intent
            )
        }


    }

}