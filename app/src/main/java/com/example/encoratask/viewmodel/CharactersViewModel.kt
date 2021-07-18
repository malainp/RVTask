package com.example.encoratask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.encoratask.models.Character
import com.example.encoratask.repositories.CharactersRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private  val repository: CharactersRepo
) : ViewModel() {

    private val mCharactersList: MutableLiveData<List<Character>> = MutableLiveData()

    private val mCharacter: MutableLiveData<Character> = MutableLiveData()

    val characters: LiveData<List<Character>> get() = mCharactersList

    val character: LiveData<Character> get() = mCharacter

    private var job: Job? = null
    private var job2: Job? = null

    fun getCharacters() {
        if (job?.isActive == true)
            return
        job = getCharactersExec()
    }

    fun getCharacter(id: Int) {
        if (job2?.isActive == true)
            return
        job = getCharacterExec(id)
    }

    private fun getCharactersExec() = GlobalScope.launch(Dispatchers.IO) {
        val characters = repository.get()
        mCharactersList.postValue( characters)
    }

    private fun getCharacterExec(id: Int) = GlobalScope.launch (Dispatchers.IO) {
        val character = repository.getCharacter(id)
        mCharacter.postValue(character)
    }
}