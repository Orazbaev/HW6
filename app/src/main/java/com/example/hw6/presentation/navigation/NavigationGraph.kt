package com.example.hw6.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hw6.presentation.screens.TrackListScreen
import com.example.hw6.presentation.screens.TrackDetailScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "track_list") {
        composable("track_list") {
            TrackListScreen(navController)
        }
        composable("track_detail/{trackId}") { backStackEntry ->
            val trackId = backStackEntry.arguments?.getString("trackId")
            TrackDetailScreen(trackId = trackId)
        }
    }
}
