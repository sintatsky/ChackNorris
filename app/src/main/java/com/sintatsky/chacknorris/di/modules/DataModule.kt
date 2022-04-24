package com.sintatsky.chacknorris.di.modules

import com.sintatsky.chacknorris.data.repository.JokeRepositoryImpl
import com.sintatsky.chacknorris.domain.repository.JokeRepository
import dagger.Binds
import dagger.Module

@Module
interface DataModule {
    @Binds
    fun bindJokeRepository(impl: JokeRepositoryImpl): JokeRepository

}