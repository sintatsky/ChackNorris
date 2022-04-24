package com.sintatsky.chacknorris.domain.repository


import com.sintatsky.chacknorris.domain.entity.JokesValue

interface JokeRepository {

    suspend fun loadJokes(count: Int): List<JokesValue>
}