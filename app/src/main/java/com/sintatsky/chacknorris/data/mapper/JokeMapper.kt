package com.sintatsky.chacknorris.data.mapper

import com.sintatsky.chacknorris.data.network.JokesValueDto
import com.sintatsky.chacknorris.domain.entity.JokesValue
import javax.inject.Inject

class JokeMapper @Inject constructor() {

    fun mapFromDtoToEntity(dto: JokesValueDto) = JokesValue(
        id = dto.id,
        joke = dto.joke
    )
}