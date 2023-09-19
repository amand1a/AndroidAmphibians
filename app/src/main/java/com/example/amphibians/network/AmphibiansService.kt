package com.example.amphibians.network

import retrofit2.http.GET

interface AmphibiansService{
    @GET("amphibians")
    suspend fun getAmphibians(): List<Amphibian>
}