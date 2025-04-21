package com.example.hw6.data.repository

import com.example.hw6.data.source.TrackDataSource
import com.example.hw6.domain.model.Track
import com.example.hw6.domain.repository.TrackRepository

class TrackRepositoryImpl(private val dataSource: TrackDataSource) : TrackRepository {
    override fun getTrackList(): List<Track> = dataSource.fetchTracks()
}
