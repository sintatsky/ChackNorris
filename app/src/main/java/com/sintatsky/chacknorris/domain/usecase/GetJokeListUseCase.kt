package com.sintatsky.chacknorris.domain.usecase

import com.sintatsky.chacknorris.domain.repository.JokeRepository
import javax.inject.Inject

class GetJokeListUseCase @Inject constructor(
    private val repository: JokeRepository
) {
    suspend operator fun invoke(count: Int) = repository.loadJokes(count)
}