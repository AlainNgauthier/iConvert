package com.alaingauthier1.iconvert

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.alaingauthier1.iconvert.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val navController by lazy { findNavController(R.id.navHostFragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        setupNavController()
        setupAppBar()
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        binding.bottomMenuNav.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = navController
        return navController.navigateUp()
                || super.onSupportNavigateUp()
    }

    private fun setupNavController() {
        navController
            .addOnDestinationChangedListener { _, dest, _ ->
                binding.bottomMenuNav.visibility =
                    when (dest.id) {
                        R.id.ratesFragment -> View.VISIBLE

                        else -> View.GONE
                    }
            }
    }

    private fun setupAppBar() {
        val navController = navController
        val appBarConfig = AppBarConfiguration.Builder(
            R.id.ratesFragment
        ).build()
        setupActionBarWithNavController(navController, appBarConfig)
    }
}