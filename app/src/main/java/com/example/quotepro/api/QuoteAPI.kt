package com.example.quotepro.api

import com.example.quotepro.models.QuoteItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface QuoteAPI {

    @GET("v3/b/66fecc0aacd3cb34a890a19d?meta=false")
    suspend fun getQuotes(@Header("X-JSON-Path") category: String) : retrofit2.Response<List<QuoteItem>>

    @GET("v3/b/66fecc0aacd3cb34a890a19d?meta=false")
    @Headers("X-JSON-Path:quotes..category")
    suspend fun getCategories() : Response<List<String>>
}