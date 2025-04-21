package com.example.hw6.presentation

import androidx.lifecycle.ViewModel
import com.example.hw6.R
import com.example.hw6.domain.model.Track
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TrackViewModel : ViewModel() {

    private val _tracks = MutableStateFlow(
        listOf(
            Track(1, "Blinding Lights", "Pop", 3.2, R.drawable.blinding_lights),
            Track(2, "Bohemian Rhapsody", "Rock", 5.9, R.drawable.bohemian_rhapsody),
            Track(3, "Shape of You", "Pop", 4.1, R.drawable.shape_of_you),
            Track(4, "Lose Yourself", "Rap", 5.3, R.drawable.lose_yourself),
            Track(5, "Smells Like Teen Spirit", "Grunge", 5.0, R.drawable.nirvana)
        )
    )

    val tracks: StateFlow<List<Track>> = _tracks

    fun getTrackById(trackId: Int): Track? {
        return tracks.value.find { it.id == trackId }
    }
}
