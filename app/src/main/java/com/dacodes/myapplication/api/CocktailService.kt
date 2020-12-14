package com.dacodes.myapplication.api

import com.dacodes.myapplication.models.DrinkResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CocktailService {

    @Headers("Content-type: application/json")
    @GET("json/v1/1/search.php")
    fun getCocktails(@Query("s") drink: String): Call<DrinkResponse>

}

