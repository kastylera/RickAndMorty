package com.example.rickandmorty.ui.screens.root

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.example.rickandmorty.ui.screens.details.DetailContent
import com.example.rickandmorty.ui.screens.list.ListContent

@Composable
fun RootContent(
    component: RootComponent,
    modifier: Modifier = Modifier,
) {
    Children(
        stack = component.stack,
        modifier = modifier,
        animation = stackAnimation(slide()),
    ) {
        when (val child = it.instance) {
            is RootComponent.Child.Detail -> DetailContent(
                component = child.component,
                modifier = Modifier.fillMaxSize(),
            )

            is RootComponent.Child.List -> ListContent(
                component = child.component,
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}
