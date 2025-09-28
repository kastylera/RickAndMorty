package com.example.rickandmorty.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.arkivanov.decompose.defaultComponentContext
import com.example.rickandmorty.ui.screens.root.RootComponent
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val rootComponentFactory: RootComponent.Factory by inject()
        val rootComponent = rootComponentFactory(defaultComponentContext())
        setContent {
            App(rootComponent)
        }
    }
}
