package com.example.encoratask.di

import com.example.encoratask.networking.RMService
import com.example.encoratask.repositories.CharactersRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    @Singleton
    fun provideCharactersRepository(
        charactersService: RMService
    ): CharactersRepo {
        return CharactersRepo(charactersService)
    }
}