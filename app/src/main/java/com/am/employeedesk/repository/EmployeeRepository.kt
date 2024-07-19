package com.am.employeedesk.repository

import com.am.employeedesk.model.EmployeeList
import com.am.employeedesk.network.EmployeeApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class EmployeeRepository @Inject constructor(private val employeeApi: EmployeeApi) {

    private val _empList = MutableStateFlow<List<EmployeeList>>(emptyList())
    val empList: StateFlow<List<EmployeeList>>
        get() = _empList


    suspend fun getEmpList() {
        val response = employeeApi.getUser()
        if (response.isNotEmpty()) {
            _empList.emit(response)
        }
    }

}