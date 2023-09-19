package com.example.amphibians.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibians.ui.screens.AmphibianceScreen
import com.example.amphibians.ui.screens.AmphibiansViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmphibiansApp(){
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(
                text = "Amphibiance",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.displaySmall)})
        }
    ) {
        Surface(modifier = Modifier
            .fillMaxSize()
            .padding(it)) {

            val viewModel: AmphibiansViewModel = viewModel(factory = AmphibiansViewModel.Factory)
            AmphibianceScreen(viewModel = viewModel)
        }
    }
}