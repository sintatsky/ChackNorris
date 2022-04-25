package com.sintatsky.chacknorris.presentation

import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.TranslatorOptions

object Translator {

    private val options = TranslatorOptions.Builder()
        .setSourceLanguage(TranslateLanguage.ENGLISH)
        .setTargetLanguage(TranslateLanguage.RUSSIAN)
        .build()

    val translator = Translation.getClient(options)
}