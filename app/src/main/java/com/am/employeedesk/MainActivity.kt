package com.am.employeedesk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.am.employeedesk.ui.components.DetailsScreen
import com.am.employeedesk.ui.components.NoNetwork
import com.am.employeedesk.ui.components.UserScreen
import com.am.employeedesk.ui.theme.EmployeeDeskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmployeeDeskTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UserScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

