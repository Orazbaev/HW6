package com.example.hw6.di

import com.example.hw6.data.repository.TrackRepositoryImpl
import com.example.hw6.data.source.TrackDataSource
import com.example.hw6.domain.repository.TrackRepository
import com.example.hw6.domain.usecase.GetTrackListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTrackDataSource(): TrackDataSource = TrackDataSource()

    @Provides
    @Singleton
    fun provideTrackRepository(dataSource: TrackDataSource): TrackRepository =
        TrackRepositoryImpl(dataSource)

    @Provides
    @Singleton
    fun provideGetTrackListUseCase(repository: TrackRepository): GetTrackListUseCase =
        GetTrackListUseCase(repository)
}
