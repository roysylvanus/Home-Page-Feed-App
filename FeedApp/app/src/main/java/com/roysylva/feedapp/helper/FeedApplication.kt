package com.roysylva.feedapp.helper

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//this is our main application class that governs the whole app
@HiltAndroidApp
class FeedApplication :Application(){

    override fun onCreate() {
        super.onCreate()
    }
}