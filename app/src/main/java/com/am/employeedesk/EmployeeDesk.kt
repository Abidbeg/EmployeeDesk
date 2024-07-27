package com.am.employeedesk

import android.app.Application
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.am.employeedesk.di.DatabaseModule
import com.am.employeedesk.di.NetworkModule
import com.am.employeedesk.network.EmployeeApi
import com.am.employeedesk.repository.EmployeeDetailsRepository
import com.am.employeedesk.repository.EmployeeRepository
import com.am.employeedesk.worker.EmployeeWorker
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import java.util.concurrent.TimeUnit

@HiltAndroidApp
class EmployeeDesk : Application() {
    lateinit var employeeRepository: EmployeeDetailsRepository
    override fun onCreate() {
        super.onCreate()
//        if (GsonBuildConfig.) {
        Timber.plant(Timber.DebugTree())
//        }
        initialize()
        setUpWorker()
    }

    private fun setUpWorker() {
        val constraint = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
        val workRequest =
            PeriodicWorkRequest.Builder(EmployeeWorker::class.java, 15, TimeUnit.MINUTES)
                .setConstraints(constraint).build()
        WorkManager.getInstance(this).enqueue(workRequest)
    }


    private fun initialize() {
        val employeeApi = NetworkModule.provideRetrofit().create(EmployeeApi::class.java)
        val database = DatabaseModule.provideDatabase(applicationContext)

        employeeRepository = EmployeeDetailsRepository(employeeApi, database)
    }
}