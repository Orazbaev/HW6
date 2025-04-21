package com.example.hw6.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hw6.presentation.TrackViewModel
import com.example.hw6.presentation.TrackCard
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TrackListScreen(navController: NavController) {
    val viewModel: TrackViewModel = hiltViewModel()
    val tracks by viewModel.tracks.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            items(tracks) { track ->
                TrackCard(
                    track = track,
                    onClick = {
                        navController.navigate("track_detail/${track.id}")
                    }
                )
            }
        }
    }
}
