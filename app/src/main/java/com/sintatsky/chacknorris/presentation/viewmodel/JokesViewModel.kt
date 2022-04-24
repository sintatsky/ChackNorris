package com.sintatsky.chacknorris.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sintatsky.chacknorris.domain.entity.JokesValue
import com.sintatsky.chacknorris.domain.usecase.GetJokeListUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class JokesViewModel @Inject constructor(
    private val getJokeListUseCase: GetJokeListUseCase
) : ViewModel() {

   private val _jokeList = MutableLiveData<List<JokesValue>>()
    val jokeList: LiveData<List<JokesValue>> = _jokeList

    fun loadData(count: Int) {
        viewModelScope.launch {
            val result = getJokeListUseCase(count)
            _jokeList.value = result
        }
    }
}

