package com.example.hw6.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.*
import com.example.hw6.domain.model.Track
import com.example.hw6.ui.theme.CarDealerTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarDealerTheme {
                val viewModel: TrackViewModel = hiltViewModel()
                val tracks by viewModel.tracks.collectAsState()
                var selectedGenre by remember { mutableStateOf("All") }

                val genres = listOf("All") + tracks.map { it.genre }.distinct()
                val filteredTracks = if (selectedGenre == "All") tracks else tracks.filter { it.genre == selectedGenre }

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "track_list") {
                    composable("track_list") {
                        Scaffold(
                            topBar = {
                                TopAppBar(
                                    title = { Text("Каталог Музыки", color = Color.White) },
                                    colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF263238))
                                )
                            }
                        ) { padding ->
                            Column(
                                modifier = Modifier
                                    .padding(padding)
                                    .padding(16.dp)
                            ) {
                                GenreFilter(
                                    genres = genres,
                                    selectedGenre = selectedGenre,
                                    onGenreSelected = { selectedGenre = it }
                                )

                                Spacer(modifier = Modifier.height(16.dp))

                                LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                                    items(filteredTracks) { track ->
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
                    }

                    composable("track_detail/{trackId}") { backStackEntry ->
                        val trackId = backStackEntry.arguments?.getString("trackId")
                        TrackDetailScreen(trackId = trackId)
                    }
                }
            }
        }
    }
}

@Composable
fun GenreFilter(genres: List<String>, selectedGenre: String, onGenreSelected: (String) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        genres.forEach { genre ->
            FilterChip(
                selected = genre == selectedGenre,
                onClick = { onGenreSelected(genre) },
                label = { Text(genre) },
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = Color(0xFF6200EE),
                    containerColor = Color.LightGray
                ),
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}

@Composable
fun TrackCard(track: Track, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = track.imageResId),
                contentDescription = "${track.title} cover",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = track.title,
                style = MaterialTheme.typography.headlineSmall,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = track.genre,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Blue
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "${track.duration} мин",
                style = MaterialTheme.typography.bodyLarge,
                color = Color(0xFF1B5E20)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onClick,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Подробнее")
            }
        }
    }
}

@Composable
fun TrackDetailScreen(trackId: String?) {
    Text(text = "Информация о треке с ID: $trackId")
}
