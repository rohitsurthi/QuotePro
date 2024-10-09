package com.example.quotepro.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotepro.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: QuoteRepository) : ViewModel() {

    val categories : StateFlow<List<String>>
        get() = repository.categories

    init {
        viewModelScope.launch {
            repository.getQuotes("life")
        }
    }
}