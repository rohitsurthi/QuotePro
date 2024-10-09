package com.example.quotepro.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quotepro.models.QuoteItem
import com.example.quotepro.repository.DetailViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.graphics.Color

@Composable
fun DetailScreen() {
    val detailViewModel : DetailViewModel = viewModel()
    val quotes : State<List<QuoteItem>> = detailViewModel.quotes.collectAsState()

    LazyColumn(
        content = {
            items(quotes.value) {
                QuoteListItem(it.quote)
            }
        }
    )
}

@Composable
fun QuoteListItem(quote: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(15.dp)
            .background(Color.LightGray),
        content = {
            Text(
                modifier = Modifier
                    .padding(10.dp),
                text = quote,
                color = Color.Blue,
            )
        }
    )
}