package com.example.rickandmorty.ui.screens.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListContent(
    component: ListComponent,
    modifier: Modifier = Modifier,
) {
    val state = component.model.collectAsLazyPagingItems()

    Scaffold(
        modifier = modifier,
        topBar = { TopAppBar(title = { Text("List") }) }
    ) { paddingValues ->
        LazyColumn(
            state = rememberLazyListState(),
            modifier = Modifier.padding(paddingValues)
        ) {
            items(state.itemCount, key = state.itemKey { it.id }) {
                val item = state[it]!!
                Row(
                    modifier = Modifier
                    .fillMaxWidth()
                    .clickable { component.onItemClicked(item) }
                    .padding(16.dp)
                ) {
                    Text(item.name)
                }
            }
        }
    }
}
