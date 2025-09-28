package com.example.rickandmorty.ui.screens.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import coil3.compose.AsyncImage
import com.example.rickandmorty.domain.models.CharacterData
import com.example.rickandmorty.ui.theme.AppTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListContent(
    component: ListComponent,
    modifier: Modifier = Modifier,
) {
    val lazyCharacters = component.characters.collectAsLazyPagingItems()

    Scaffold(
        modifier = modifier, topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "All Characters",
                        style = AppTheme.typography.title,
                        color = AppTheme.colors.text.primary
                    )
                }, colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = AppTheme.colors.backgrounds.primary
                )
            )
        }
    ) { paddingValues ->
        when {
            lazyCharacters.loadState.refresh is LoadState.Loading -> {
                LoadingBar(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                )
            }

            lazyCharacters.loadState.refresh is LoadState.Error -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    ErrorBadge(
                        errorState = lazyCharacters.loadState.refresh as LoadState.Error,
                        onRetry = { lazyCharacters.retry() }
                    )
                }
            }

            lazyCharacters.itemCount == 0 -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No characters found",
                        style = AppTheme.typography.body,
                        color = AppTheme.colors.text.secondary
                    )
                }
            }

            else -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    items(lazyCharacters.itemCount) { index ->
                        lazyCharacters[index]?.let { character ->
                            CharacterItem(
                                character = character,
                                onClick = { component.onItemClicked(character) }
                            )
                        }
                    }

                    lazyCharacters.apply {
                        when (loadState.append) {
                            is LoadState.Loading -> {
                                item {
                                    LoadingBar(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(16.dp)
                                    )
                                }
                            }

                            is LoadState.Error -> {
                                item {
                                    ErrorBadge(
                                        errorState = loadState.append as LoadState.Error,
                                        onRetry = { retry() })
                                }
                            }

                            else -> {
                                /* no-op */
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun CharacterItem(character: CharacterData, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = AppTheme.colors.backgrounds.card
        ),
        shape = AppTheme.shapes.r16,
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = character.image,
                contentDescription = character.name,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = character.name,
                    style = AppTheme.typography.title,
                    color = AppTheme.colors.text.primary
                )
                Text(
                    text = "${character.status} - ${character.species}",
                    style = AppTheme.typography.body,
                    color = when (character.status) {
                        "Alive" -> AppTheme.colors.badges.alive
                        "Dead" -> AppTheme.colors.badges.dead
                        else -> AppTheme.colors.badges.unknown
                    }
                )
                Text(
                    text = "Last location: ${character.location.name}",
                    style = AppTheme.typography.caption,
                    color = AppTheme.colors.text.secondary
                )
            }
        }
    }
}

@Composable
private fun ErrorBadge(
    errorState: LoadState.Error,
    onRetry: () -> Unit,
) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Error: ${errorState.error.localizedMessage}",
                style = AppTheme.typography.body,
                color = AppTheme.colors.text.error
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { onRetry() }) {
                Text(
                    "Retry", style = AppTheme.typography.body,
                    color = AppTheme.colors.text.white
                )
            }
        }
}

@Composable
private fun LoadingBar(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(color = AppTheme.colors.buttons.primary)
    }
}
