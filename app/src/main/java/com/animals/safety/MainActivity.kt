package com.animals.safety

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.navigateUp
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.animals.safety.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  
  private lateinit var appBarConfiguration: AppBarConfiguration
  
  private lateinit var binding: ActivityMainBinding
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    setSupportActionBar(binding.toolbar)
    
    val navController = findNavController(this, R.id.nav_host_fragment_content_main)
    appBarConfiguration = AppBarConfiguration.Builder(navController.graph).build()
    setupActionBarWithNavController(this, navController, appBarConfiguration)
  }
  
  override fun onSupportNavigateUp(): Boolean {
    val navController = findNavController(this, R.id.nav_host_fragment_content_main)
    return (navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp())
  }
  
}
