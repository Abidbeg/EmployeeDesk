package com.am.employeedesk.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.am.employeedesk.R

@Preview(widthDp = 300, heightDp = 500)
@Composable
fun NoNetwork(modifier: Modifier = Modifier) {
    Box(
        modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 32.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                modifier = modifier
                    .size(100.dp)
                    .padding(bottom = 16.dp),
                tint = Color(0xFF00824F),
                painter = painterResource(id = R.drawable.network_check),
                contentDescription = "network_check"
            )
            Text(
                text = "Please check your network connection",
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }

}