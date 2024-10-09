package com.example.quotepro.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quotepro.viewmodels.CategoryViewModel

@Composable
fun CategoryScreen() {

    val categoryViewModel : CategoryViewModel = viewModel()
    val categories : State<List<String>> = categoryViewModel.categories.collectAsState()

    LazyVerticalGrid (
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        items(categories.value.distinct()) {
            CategoryItem(category = it)
        }
    }
}


@Composable
fun CategoryItem(category: String) {
    Box(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .padding(10.dp)
            .background(Color.LightGray)
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.Center),
            text = category
        )
    }
}