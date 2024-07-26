package com.am.employeedesk

import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.am.employeedesk.ui.components.DetailsScreen
import com.am.employeedesk.ui.components.UserScreen

@Composable
fun ComposeApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Route.USER) {

        composable(Route.USER) { backStackEntry ->
            UserScreen(
                onUserClick = { username ->
                    // In order to discard duplicated navigation events, we check the Lifecycle
//                    if (backStackEntry.lifecycle.currentState == Lifecycle.State.RESUMED) {
                    navController.navigate("${Route.DETAIL}/$username")
//                    }
                }
            )
        }
        composable(
            "${Route.DETAIL}/{${Argument.USERNAME}}",
            arguments = listOf(navArgument(Argument.USERNAME) { type = NavType.StringType })
        )
        {
            DetailsScreen()
        }

    }

}

object Route {
    const val USER = "user"
    const val DETAIL = "detail"
}

object Argument {
    const val USERNAME = "username"
}