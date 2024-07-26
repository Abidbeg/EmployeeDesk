package com.am.employeedesk.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.am.employeedesk.repository.EmployeeDetailsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class EmployeeDetailsViewModel @Inject constructor(
    private val employeeDetailsRepository: EmployeeDetailsRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {


    private val userName: String? = savedStateHandle["username"]
    var uiState by mutableStateOf(DetailsUiState())
        private set

    init {
        userName?.let {
            viewModelScope.launch(Dispatchers.IO) {
                employeeDetailsRepository.refereshDetails(it)
                employeeDetailsRepository.getUserDetails(it).collect { details ->
                    withContext(Dispatchers.Main)
                    {
                        uiState = if (details == null) {
                            uiState.copy(offline = true)
                        } else {
                            uiState.copy(details, false)
                        }
                    }
                }
            }
        }
    }

}