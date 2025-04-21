package com.example.hw6.domain.repository

import com.example.hw6.domain.model.Track

interface TrackRepository {
    fun getTrackList(): List<Track>
}
