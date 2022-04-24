package com.sintatsky.chacknorris.di.modules

import androidx.lifecycle.ViewModel
import com.sintatsky.chacknorris.di.annotation.ViewModelKey
import com.sintatsky.chacknorris.presentation.viewmodel.JokesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(JokesViewModel::class)
    fun bindJokesViewModel(viewModel: JokesViewModel): ViewModel
}