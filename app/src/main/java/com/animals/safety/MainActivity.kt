package com.animals.safety

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.animals.safety.screens.Screen
import com.animals.safety.ui.theme.AimantsDanimauxTheme

class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      val navController = rememberNavController()

      AimantsDanimauxTheme {
        AimantsDanimauxNavHost(navHostController = navController)
      }
    }
  }

}

@Composable
fun AimantsDanimauxNavHost(navHostController: NavHostController) {
  NavHost(
    navController = navHostController,
    startDestination = Screen.Home.route
  ) {
    composable(route = Screen.Home.route) {
      
    }
  }
}
