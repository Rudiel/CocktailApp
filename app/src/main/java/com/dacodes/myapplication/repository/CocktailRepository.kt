package com.dacodes.myapplication.repository

import com.dacodes.myapplication.App
import com.dacodes.myapplication.api.CocktailService
import com.dacodes.myapplication.models.Drink
import com.dacodes.myapplication.models.DrinkResponse
import retrofit2.Call
import javax.inject.Inject
import javax.security.auth.callback.Callback

class CocktailRepository {

    @Inject
    lateinit var cocktailService: CocktailService


    init {
        App.appComponent.inject(this)
    }

    fun getCocktails(name: String) : Call<DrinkResponse>{
      return  cocktailService.getCocktails(name)
    }

}