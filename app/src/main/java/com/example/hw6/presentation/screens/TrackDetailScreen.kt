package com.example.hw6.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.hw6.domain.model.Track
import com.example.hw6.presentation.TrackViewModel

@Composable
fun TrackDetailScreen(trackId: String?) {
    val viewModel: TrackViewModel = hiltViewModel()
    val track = remember(trackId) {
        trackId?.toIntOrNull()?.let { viewModel.getTrackById(it) }
    }

    if (track == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Трек не найден", style = MaterialTheme.typography.bodyLarge)
        }
    } else {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = track.title, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Жанр: ${track.genre}")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Длительность: ${track.duration} мин")
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = track.imageResId),
                contentDescription = "${track.title} cover",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(12.dp))
            )
        }
    }
}

