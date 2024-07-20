package com.am.employeedesk

import android.app.Application
import com.google.gson.internal.GsonBuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class EmployeeDesk : Application() {
    override fun onCreate() {
        super.onCreate()
//        if (GsonBuildConfig.) {
            Timber.plant(Timber.DebugTree())
//        }
    }
}