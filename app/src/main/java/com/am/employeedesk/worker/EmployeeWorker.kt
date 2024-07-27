package com.am.employeedesk.worker

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.am.employeedesk.EmployeeDesk
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class EmployeeWorker @Inject constructor(
    private val context: Context,
    param: WorkerParameters,
) :
    Worker(context, param) {
    override fun doWork(): Result {
        val repository = (context as EmployeeDesk).employeeRepository
        CoroutineScope(Dispatchers.IO).launch {
            repository.getBackgroundEmpList()
        }

        return Result.success()
    }
}