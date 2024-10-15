package com.example.practicainvestigacion.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practicainvestigacion.ui.screens.DetailScreen
import com.example.practicainvestigacion.ui.screens.HomeScreen
import com.example.practicainvestigacion.ui.viewmodels.DemoViewModel


@Composable
fun NavigationApp(demoViewModel: DemoViewModel = viewModel()){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route  ){

        composable(Screen.Home.route){
            HomeScreen(navController, demoViewModel)
        }

        composable(route = Screen.Detail.route){
            DetailScreen(navController, demoViewModel)
        }
    }
}