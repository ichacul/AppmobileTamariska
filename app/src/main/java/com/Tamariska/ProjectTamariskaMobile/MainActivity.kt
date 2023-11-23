package com.Tamariska.ProjectTamariskaMobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.Tamariska.ProjectTamariskaMobile.screens.Home
import com.Tamariska.ProjectTamariskaMobile.screens.Profile
import com.Tamariska.ProjectTamariskaMobile.screens.Settings

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenMain()
        }
    }

    @Composable
    fun ScreenMain() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Routes.Home.route) {
            composable(Routes.Home.route) {
                Home(navController = navController)
            }
            composable(Routes.Profile.route) {
                Profile()
            }
            composable(Routes.Settings.route + "/{no}") { navBackStack ->
                val number = navBackStack.arguments?.getString("no")
                Settings(number = number)
            }
        }

    }

}