package com.example.rickandmorty.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rickandmorty.domain.models.CharacterData
import com.example.rickandmorty.ui.screens.details.CharacterDetailsScreen
import com.example.rickandmorty.ui.screens.list.CharacterListScreen
import com.example.rickandmorty.ui.state.AppState
import com.example.rickandmorty.ui.utils.NavigationUtils.getNavigationData
import com.example.rickandmorty.ui.utils.NavigationUtils.hideKeyboardAndPopBackStack
import com.example.rickandmorty.ui.utils.NavigationUtils.putAndNavigate
import com.example.rickandmorty.ui.utils.leftInAnimation
import com.example.rickandmorty.ui.utils.leftOutAnimation
import com.example.rickandmorty.ui.utils.rightInAnimation
import com.example.rickandmorty.ui.utils.rightOutAnimation


@Composable
fun AppNavigation(
    startDestinationRoute: String,
    appState: AppState
) {
    val onBackPress: () -> Unit = { appState.navController.hideKeyboardAndPopBackStack() }

    NavHost(appState.navController, startDestination = startDestinationRoute) {
        composable(
            route = Destination.CharacterList.route,
            enterTransition = { leftInAnimation },
            exitTransition = { rightOutAnimation },
            popEnterTransition = { rightInAnimation },
            popExitTransition = { leftOutAnimation },
        ) {
            CharacterListScreen(toDetails = {
                appState.putAndNavigate(CHARACTER, it, Destination.CharacterDetails.route)
            })
        }
        composable(
            route = Destination.CharacterDetails.route,
            enterTransition = { leftInAnimation },
            exitTransition = { rightOutAnimation },
            popEnterTransition = { rightInAnimation },
            popExitTransition = { leftOutAnimation },
        ) {
            CharacterDetailsScreen(
                character = appState.getNavigationData(CHARACTER) ?: CharacterData.DEFAULT,
                onBack = onBackPress
            )
        }
    }
}
