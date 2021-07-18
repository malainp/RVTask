package com.example.encoratask.repositories

import com.example.encoratask.models.Character
import com.example.encoratask.networking.RMService
import javax.inject.Inject


class CharactersRepo @Inject constructor(
    private val characterService: RMService
) {
    suspend fun get(): List<Character> {
        val result = characterService.getCharacters()
        return result.results
        //return listOf()
    }

    suspend fun getCharacter(id: Int): Character {
        return characterService.getCharacter(id)
        //return Character(0, "", "", "")
    }
}