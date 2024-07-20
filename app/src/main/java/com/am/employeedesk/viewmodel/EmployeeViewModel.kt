package com.am.employeedesk.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.am.employeedesk.repository.EmployeeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class EmployeeViewModel @Inject constructor(private val repository: EmployeeRepository) :
    ViewModel() {

    var empList by mutableStateOf(EmployeeUiState())
        private set
    /*val empList: StateFlow<List<EmployeeList>>
        get() = repository.empList
*/

    /*init {
        viewModelScope.launch {
            repository.getEmpList()
        }
    }*/

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getEmpList()
            repository.getEmpList.collect { list ->
                withContext(Dispatchers.Main)
                {
                    empList = if (list.isNullOrEmpty()) {
                        empList.copy(offline = true)
                    } else {
                        empList.copy(list, false)
                    }
                }
            }
        }
    }
}