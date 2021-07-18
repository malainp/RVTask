package com.example.encoratask.networking

import com.example.encoratask.models.Character
import com.example.encoratask.models.CharactersResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RMService {
    @GET("character/")
    suspend fun getCharacters(): CharactersResponse

    @GET("character/{charId}")
    suspend fun getCharacter(@Path("charId") charId: Int): Character
}