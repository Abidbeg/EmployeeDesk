package com.am.employeedesk.repository

import com.am.employeedesk.database.AppDataBase
import com.am.employeedesk.database.asDomainModel
import com.am.employeedesk.domain.Employee
import com.am.employeedesk.model.asDatabaseModel
import com.am.employeedesk.network.EmployeeApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import timber.log.Timber
import javax.inject.Inject

class EmployeeRepository @Inject constructor(
    private val employeeApi: EmployeeApi,
    private val appDataBase: AppDataBase
) {

    /* private val _empList = MutableStateFlow<List<EmployeeList>>(emptyList())
     val empList: StateFlow<List<EmployeeList>>
         get() = _empList*/

    val getEmpList: Flow<List<Employee>?> =
        appDataBase.employeeDao.getEmployee().map { it?.asDomainModel() }


    suspend fun getEmpList() {
        try {
            val response = employeeApi.getUser()
            appDataBase.employeeDao.insertEmployee(response.asDatabaseModel())
        } catch (e: Exception) {
            Timber.w(e)
        }
    }

    suspend fun getBackgroundEmpList() {
        val response = employeeApi.getUser()
        appDataBase.employeeDao.insertEmployee(response.asDatabaseModel())
    }

}