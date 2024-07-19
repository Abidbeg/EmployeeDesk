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
import com.am.employeedesk.R

@Composable
fun DetailsScreen(modifier: Modifier) {
    Row {
        Image(
            modifier = modifier.size(100.dp),
            painter = painterResource(id = R.drawable.network_check),
            contentDescription = "check"
        )
        Column {
            Text(text = "Abidbeg")
            Text(text = "23/01/1993")
            Text(text = "Oshawa, Canada")
        }
    }

}