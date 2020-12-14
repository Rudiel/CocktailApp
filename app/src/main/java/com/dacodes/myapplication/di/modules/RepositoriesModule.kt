package com.dacodes.myapplication.di.modules

import com.dacodes.myapplication.repository.CocktailRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoriesModule {

    @Provides
    fun provideCocktailRepository(): CocktailRepository {
        return CocktailRepository()
    }


}