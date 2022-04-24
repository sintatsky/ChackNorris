package com.sintatsky.chacknorris.di.modules

import com.sintatsky.chacknorris.data.network.JokesApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @Provides
    fun provideJokeApi(): JokesApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(JokesApi::class.java)
    }

    companion object {
        private const val BASE_URL = "http://api.icndb.com/"
    }
}