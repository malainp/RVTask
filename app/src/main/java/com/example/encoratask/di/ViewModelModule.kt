package com.example.encoratask.di

import com.example.encoratask.repositories.CharactersRepo
import com.example.encoratask.viewmodel.CharactersViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    fun provideCharactersViewModel(
        charactersRepo: CharactersRepo
    ): CharactersViewModel {
        return CharactersViewModel(charactersRepo)
    }
}