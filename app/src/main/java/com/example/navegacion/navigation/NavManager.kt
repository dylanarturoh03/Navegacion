package com.example.navegacion.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navegacion.views.DetailView
import com.example.navegacion.views.FinalView
import com.example.navegacion.views.HomeView

@Composable
fun NavManager(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home"  ){
        composable("Home"){
            HomeView(navController)
        }
        composable("Detail/{id}/?{opcional}", arguments = listOf(
            navArgument("id") { type = NavType.StringType },
            navArgument("opcional") { type = NavType.StringType },
        )){
            val id = it.arguments?.getString("id") ?: ""
            val opcional = it.arguments?.getString("opcional") ?: ""
            DetailView(navController, id, opcional)
        }
        composable("Final/{id}/?{opcional}", arguments = listOf(
            navArgument("id") { type = NavType.StringType},
            navArgument("opcional") { type = NavType.StringType},
        )){
            val id = it.arguments?.getString("id") ?: ""
            val opcional = it.arguments?.getString("opcional") ?: ""
            FinalView(navController, id, opcional)
        }
    }
}