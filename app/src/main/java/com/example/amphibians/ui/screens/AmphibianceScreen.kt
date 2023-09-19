package com.example.amphibians.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibians.network.Amphibian


@Composable
fun AmphibianceScreen(viewModel: AmphibiansViewModel){
    val uiState = viewModel.amphibiansUiState

    when(uiState){
        is AmphibiansUiState.Success -> {
            AmpibiansList(amphibians = uiState.amphibians)
        }
        is AmphibiansUiState.Error -> {

        }
        is AmphibiansUiState.Loading -> {

        }
    }
}

@Composable
fun AmpibiansList(amphibians: List<Amphibian>){
    LazyColumn(){
        items(amphibians){
            AmphibianCard(amphibian = it, modifier  = Modifier.padding(horizontal = 8.dp, vertical = 8.dp))
        }
    }
}

@Composable
fun AmphibianCard(amphibian: Amphibian, modifier: Modifier = Modifier){
    Card(modifier = Modifier) {
        Text(text ="${amphibian.name} (${amphibian.type})",
        style = MaterialTheme.typography.titleMedium)
        AsyncImage(model = ImageRequest.Builder(context = LocalContext.current)
            .data(amphibian.imgSrc)
            .crossfade(true)
            .build(), contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp))
        Text(text = amphibian.description,
        style = MaterialTheme.typography.bodyMedium)
    }
}