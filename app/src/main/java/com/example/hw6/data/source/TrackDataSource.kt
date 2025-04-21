package com.example.hw6.data.source

import com.example.hw6.R
import com.example.hw6.domain.model.Track

class TrackDataSource {
    fun fetchTracks(): List<Track> {
        return listOf(
            Track(1, "Blinding Lights", "Pop", 3.2, R.drawable.blinding_lights),
            Track(2, "Bohemian Rhapsody", "Rock", 5.9, R.drawable.bohemian_rhapsody),
            Track(3, "Shape of You", "Pop", 4.1, R.drawable.shape_of_you),
            Track(4, "Lose Yourself", "Rap", 5.3, R.drawable.lose_yourself),
            Track(5, "Smells Like Teen Spirit", "Grunge", 5.0, R.drawable.nirvana)
        )
    }
}
