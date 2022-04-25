package com.sintatsky.chacknorris.data.network


import retrofit2.http.GET
import retrofit2.http.Path

interface JokesApi {

    @GET("jokes/random/{count}")
    suspend fun getJokeList(
        @Path("count") count: Int
    ): JokesResponseDto
}