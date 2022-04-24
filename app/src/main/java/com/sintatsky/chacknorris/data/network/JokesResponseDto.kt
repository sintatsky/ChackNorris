package com.sintatsky.chacknorris.data.network

data class JokesResponseDto(
    val type: String,
    val value: List<JokesValueDto>
)