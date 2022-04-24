package com.sintatsky.chacknorris.presentation

import android.app.Application
import com.sintatsky.chacknorris.di.component.DaggerAppComponent

class JokeApp : Application() {

    val component by lazy {
        DaggerAppComponent.factory().create(this)
    }
}