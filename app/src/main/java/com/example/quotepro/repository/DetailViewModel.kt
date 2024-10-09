package com.example.quotepro.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotepro.models.QuoteItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: QuoteRepository) : ViewModel(){
    val quotes : StateFlow<List<QuoteItem>>
        get() = repository.quotes

    init {
        viewModelScope.launch {
            repository.getQuotes("Self")
        }
    }
}