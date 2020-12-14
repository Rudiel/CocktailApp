package com.dacodes.myapplication.di.modules

import androidx.lifecycle.ViewModel
import com.dacodes.myapplication.cocktailModule.CocktailViewModel
import com.dacodes.myapplication.cocktailModule.CocktailActivity
import com.dacodes.myapplication.di.components.viewModels.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class ActivitiesModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity() : CocktailActivity

    @Binds
    @IntoMap
    @ViewModelKey(CocktailViewModel::class)
    abstract fun bindCocktailViewModel(cocktailViewModel: CocktailViewModel): ViewModel

}