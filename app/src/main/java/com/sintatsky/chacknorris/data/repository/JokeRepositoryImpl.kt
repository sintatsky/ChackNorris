package com.sintatsky.chacknorris.data.repository

import com.sintatsky.chacknorris.data.mapper.JokeMapper
import com.sintatsky.chacknorris.data.network.JokesApi
import com.sintatsky.chacknorris.domain.entity.JokesValue
import com.sintatsky.chacknorris.domain.repository.JokeRepository
import javax.inject.Inject

class JokeRepositoryImpl @Inject constructor(
    private val jokesApi: JokesApi,
    private val jokeMapper: JokeMapper
) : JokeRepository {

    override suspend fun loadJokes(count: Int): List<JokesValue> {
        return jokesApi.getJokeList(count).value.map {
            jokeMapper.mapFromDtoToEntity(it)
        }
    }
}