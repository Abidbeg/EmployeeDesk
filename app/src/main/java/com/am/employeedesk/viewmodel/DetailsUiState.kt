package com.am.employeedesk.viewmodel

import com.am.employeedesk.domain.Details
import com.aregyan.compose.util.formatDate

data class DetailsUiState(
    val detail: Details = Details(),
    val offline: Boolean = false
) {
    val formattedUserSince = formatDate(detail.userSince)
}