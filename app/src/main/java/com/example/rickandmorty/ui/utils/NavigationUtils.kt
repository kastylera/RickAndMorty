package com.example.rickandmorty.ui.utils

import android.os.Parcelable
import androidx.annotation.IdRes
import androidx.navigation.NavDirections
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.Navigator
import com.example.rickandmorty.ui.navigation.Destination
import com.example.rickandmorty.ui.state.AppState
import java.io.Serializable

object NavigationUtils {

    fun NavHostController.hideKeyboardAndPopBackStack() {
        context.hideKeyboard()
        popBackStack()
    }

    fun NavHostController.hideKeyboardAndPopBackStack(@IdRes destinationId: Int, inclusive: Boolean) {
        context.hideKeyboard()
        popBackStack(destinationId, inclusive)
    }

    fun NavHostController.hideKeyboardAndNavigate(directions: NavDirections) {
        context.hideKeyboard()
        navigate(directions)
    }

    fun NavHostController.hideKeyboardAndNavigate(directions: NavDirections, navOptions: NavOptions?) {
        context.hideKeyboard()
        navigate(directions, navOptions)
    }

    fun NavHostController.hideKeyboardAndNavigate(directions: NavDirections, navigatorExtras: Navigator.Extras) {
        context.hideKeyboard()
        navigate(directions, navigatorExtras)
    }

    fun NavHostController.hideKeyboardAndNavigate(route: String, builder: NavOptionsBuilder.() -> Unit) {
        context.hideKeyboard()
        navigate(route, builder)
    }

    fun NavHostController.hideKeyboardAndNavigate(destination: Destination, builder: NavOptionsBuilder.() -> Unit) {
        context.hideKeyboard()
        navigate(destination.route, builder)
    }

    fun NavHostController.hideKeyboardAndNavigate(destination: Destination) {
        context.hideKeyboard()
        navigate(destination.route)
    }

    fun NavHostController.hideKeyboardAndNavigate(
        route: String,
        navOptions: NavOptions? = null,
        navigatorExtras: Navigator.Extras? = null,
    ) {
        context.hideKeyboard()
        navigate(route, navOptions, navigatorExtras)
    }

    fun AppState.putToSavedStateHandle(key: String, data: Parcelable) {
        navController.currentBackStackEntry?.savedStateHandle?.set(key, data)
    }

    fun AppState.putAndNavigate(key: String, data: Parcelable, route: String, navOptions: NavOptions? = null) {
        navController.currentBackStackEntry?.savedStateHandle?.set(key, data)
        navController.navigate(route, navOptions)
    }

    fun AppState.putAndNavigate(key: String, data: Serializable, route: String, navOptions: NavOptions? = null) {
        navController.currentBackStackEntry?.savedStateHandle?.set(key, data)
        navController.navigate(route, navOptions)
    }

    fun AppState.putParcelablesAndNavigate(vararg pairs: Pair<String, Parcelable>, route: String) {
        val stateHandle = navController.currentBackStackEntry?.savedStateHandle
        pairs.forEach { (key, data) -> stateHandle?.set(key, data) }
        navController.navigate(route)
    }

    fun AppState.putAndNavigate(vararg pairs: Pair<String, String>, route: String) {
        val stateHandle = navController.currentBackStackEntry?.savedStateHandle
        pairs.forEach { (key, data) -> stateHandle?.set(key, data) }
        navController.navigate(route)
    }

    fun AppState.putAndNavigate(key: String, data: String, route: String) {
        navController.currentBackStackEntry?.savedStateHandle?.set(key, data)
        navController.navigate(route)
    }

    fun <T> AppState.getNavigationData(key: String) = navController.previousBackStackEntry?.savedStateHandle?.get<T>(key)

    fun AppState.navigate(dest: Destination) = navController.navigate(dest.route)
    fun AppState.navigate(route: String, navOptions: NavOptions? = null) = navController.navigate(route, navOptions = navOptions)

}
