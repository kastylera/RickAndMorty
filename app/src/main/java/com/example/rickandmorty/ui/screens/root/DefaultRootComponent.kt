package com.example.rickandmorty.ui.screens.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.value.Value
import com.example.rickandmorty.domain.models.CharacterData
import com.example.rickandmorty.ui.screens.details.DetailComponent
import com.example.rickandmorty.ui.screens.list.ListComponent
import kotlinx.serialization.Serializable

class DefaultRootComponent(
    componentContext: ComponentContext,
    private val listComponentFactory: ListComponent.Factory,
    private val detailComponentFactory: DetailComponent.Factory,
) : RootComponent, ComponentContext by componentContext {
    private val nav = StackNavigation<Config>()


    override val stack: Value<ChildStack<*, RootComponent.Child>> = childStack(
        source = nav,
        serializer = Config.serializer(),
        initialConfiguration = Config.List,
        handleBackButton = true,
        childFactory = ::child,
    )

    private fun child(
        config: Config,
        componentContext: ComponentContext
    ): RootComponent.Child = when (config) {
        Config.List -> RootComponent.Child.List(
            listComponentFactory(
                componentContext = componentContext,
                itemClicked = { data -> nav.pushNew(Config.Detail(data))},
            )
        )

        is Config.Detail -> RootComponent.Child.Detail(
            detailComponentFactory(
                componentContext = componentContext,
                data = config.item,
                onFinished = { nav.pop() },
            )
        )
    }

    @Serializable
    private sealed interface Config {
        @Serializable
        data object List : Config

        @Serializable
        data class Detail(val item: CharacterData) : Config
    }

    class Factory(
        private val listComponentFactory: ListComponent.Factory,
        private val detailComponentFactory: DetailComponent.Factory,
    ) : RootComponent.Factory {
        override fun invoke(componentContext: ComponentContext): RootComponent {
            return DefaultRootComponent(
                listComponentFactory = listComponentFactory,
                detailComponentFactory = detailComponentFactory,
                componentContext = componentContext,
            )
        }
    }
}
