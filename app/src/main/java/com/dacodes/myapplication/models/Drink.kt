package com.dacodes.myapplication.models

import com.google.gson.annotations.SerializedName

data class Drink(
    @SerializedName("idDrink")
    val id: String,

    @SerializedName("strDrink")
    val name: String,

    @SerializedName("strDrinkThumb")
    val image: String,

    @SerializedName("strInstructions")
    val description: String
)