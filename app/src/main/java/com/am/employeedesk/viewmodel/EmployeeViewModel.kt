package com.am.employeedesk.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.am.employeedesk.model.EmployeeList
import com.am.employeedesk.repository.EmployeeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmployeeViewModel @Inject constructor(private val repository: EmployeeRepository) :
    ViewModel() {

    val empList: StateFlow<List<EmployeeList>>
        get() = repository.empList


    init {
        viewModelScope.launch {
            repository.getEmpList()
        }
    }

}