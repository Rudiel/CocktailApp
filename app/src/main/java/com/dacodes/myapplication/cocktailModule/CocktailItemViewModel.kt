package com.dacodes.myapplication.cocktailModule

import android.app.Application
import com.dacodes.myapplication.base.BaseViewModel
import com.dacodes.myapplication.models.Drink

class CocktailItemViewModel(application: Application, private val drink: Drink) :
    BaseViewModel(application) {

    val name: String
        get() = drink.name

    val image: String
        get() = drink.image

    val description: String
        get() = drink.description

}