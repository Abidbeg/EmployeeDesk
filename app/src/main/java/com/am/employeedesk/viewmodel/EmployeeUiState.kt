package com.am.employeedesk.viewmodel

import com.am.employeedesk.domain.Employee

data class EmployeeUiState(
    val list: List<Employee> = listOf(),
    val offline: Boolean = false
)