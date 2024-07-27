package com.am.employeedesk

import android.app.Application
import com.am.employeedesk.database.AppDataBase
import com.am.employeedesk.di.DatabaseModule
import com.am.employeedesk.di.NetworkModule
import com.am.employeedesk.network.EmployeeApi
import com.am.employeedesk.repository.EmployeeRepository
import com.google.gson.internal.GsonBuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class EmployeeDesk : Application() {
    lateinit var employeeRepository: EmployeeRepository
    override fun onCreate() {
        super.onCreate()
//        if (GsonBuildConfig.) {
        Timber.plant(Timber.DebugTree())
//        }
    }


    fun initialize() {
        val employeeApi = NetworkModule.provideRetrofit().create(EmployeeApi::class.java)
        val database = DatabaseModule.provideDatabase(applicationContext)

        employeeRepository = EmployeeRepository(employeeApi, database)
    }
}