package com.example.quotepro.repository

import com.example.quotepro.api.QuoteAPI
import com.example.quotepro.models.QuoteItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val quoteAPi : QuoteAPI) {

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories : StateFlow<List<String>>
        get() = _categories

    private val _quotes = MutableStateFlow<List<QuoteItem>>(emptyList())
    val quotes : StateFlow<List<QuoteItem>>
        get() = _quotes

    suspend fun getCategories() {
        val response = quoteAPi.getCategories()
        if(response.isSuccessful && response.body() != null) {
            _categories.emit(response.body()!!)
        }
    }

    suspend fun getQuotes(category : String) {
//        val response = quoteAPi.getQuotes("quotes[?(@.category==\"$category\")]")
        val response = quoteAPi.getQuotes("quotes[?(@.category==\"$category\")]")
        if(response.isSuccessful && response.body() != null) {
            _quotes.emit(response.body()!!)
        }
    }
}