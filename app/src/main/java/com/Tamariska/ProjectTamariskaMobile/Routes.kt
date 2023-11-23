package com.Tamariska.ProjectTamariskaMobile

sealed class Routes(val route: String){
    object Home : Routes("home")
    object Profile : Routes("profile")
    object Settings : Routes("setting")
}