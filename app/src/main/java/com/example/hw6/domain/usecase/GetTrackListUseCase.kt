package com.example.hw6.domain.usecase

import com.example.hw6.domain.model.Track
import com.example.hw6.domain.repository.TrackRepository

class GetTrackListUseCase(private val repository: TrackRepository) {
    operator fun invoke(): List<Track> = repository.getTrackList()
}
