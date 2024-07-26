package com.am.employeedesk.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.am.employeedesk.R
import com.am.employeedesk.viewmodel.EmployeeDetailsViewModel

@Composable
fun DetailsScreen(modifier: Modifier = Modifier) {
    val viewModel = hiltViewModel<EmployeeDetailsViewModel>()
    val uiState = viewModel.uiState

    if (uiState.offline) {
        NoNetwork()
    } else {
        Row {
            Image(
                modifier = modifier.size(100.dp),
                painter = painterResource(id = R.drawable.network_check),
                contentDescription = "check"
            )
            Column {
                Text(text = uiState.detail.name.orEmpty())
                Text(text = uiState.formattedUserSince)
                Text(text = uiState.detail.location.orEmpty())
            }
        }
    }
}