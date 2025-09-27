package com.example.rickandmorty.ui.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.rickandmorty.ui.screens.root.RootComponent
import com.example.rickandmorty.ui.screens.root.RootContent
import com.example.rickandmorty.ui.theme.RickAndMortyTheme

@Composable
fun App(rootComponent: RootComponent) {
    RickAndMortyTheme {
         RootContent(
             component = rootComponent,
             modifier = Modifier.fillMaxSize(),
         )
     }
}
