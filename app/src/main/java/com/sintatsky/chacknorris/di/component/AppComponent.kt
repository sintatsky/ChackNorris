package com.sintatsky.chacknorris.di.component

import android.app.Application
import com.sintatsky.chacknorris.di.modules.DataModule
import com.sintatsky.chacknorris.di.modules.NetworkModule
import com.sintatsky.chacknorris.di.modules.ViewModelModule
import com.sintatsky.chacknorris.presentation.fragments.JokesFragment
import dagger.BindsInstance
import dagger.Component


@Component(
    modules = [
        DataModule::class,
        NetworkModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    fun inject(fragment: JokesFragment)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): AppComponent
    }
}