package com.am.employeedesk.worker

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.am.employeedesk.EmployeeDesk
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class EmployeeWorker @Inject constructor(
    private val context: Context,
    param: WorkerParameters,
) :
    Worker(context, param) {
    override fun doWork(): Result {
        Timber.tag("Abidbeg").d("Worker Success")
        val repository = (context as EmployeeDesk).employeeRepository
        CoroutineScope(Dispatchers.IO).launch {
            repository.getBackgroundEmpDetails()
        }

        return Result.success()
    }
}