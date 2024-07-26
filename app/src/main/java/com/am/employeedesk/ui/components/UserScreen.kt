package com.am.employeedesk.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.am.employeedesk.R
import com.am.employeedesk.domain.Employee
import com.am.employeedesk.model.EmployeeList
import com.am.employeedesk.viewmodel.EmployeeViewModel

@Composable
fun UserScreen(modifier: Modifier = Modifier, onUserClick: (String) -> Unit) {
//    val employeeViewModel: EmployeeViewModel = hiltViewModel()
//    val employeeList = employeeViewModel.empList.collectAsState()

    val viewModel = hiltViewModel<EmployeeViewModel>()
    val uiState = viewModel.empList

    if (uiState.offline) {
        NoNetwork()
    } else {
        LazyColumn {
            items(uiState.list) { item ->
                UserListItem(item, onUserClick = onUserClick)
            }

        }
    }


}

@Composable
fun UserListItem(item: Employee, modifier: Modifier = Modifier, onUserClick: (String) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onUserClick(item.username) }) {
        AsyncImage(
            modifier = modifier
                .size(80.dp)
                .padding(16.dp),
            model = item.avatar,
            contentDescription = "userImage"
        )
        Text(text = item.username)
    }
}