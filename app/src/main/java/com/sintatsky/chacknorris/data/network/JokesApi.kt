package com.sintatsky.chacknorris.data.network


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface JokesApi {

    @GET("jokes/random/{count}")
    suspend fun getJokeList(
        @Path("count") count: Int
    ): JokesResponseDto
}