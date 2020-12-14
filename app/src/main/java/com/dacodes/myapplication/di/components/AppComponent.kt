package com.dacodes.myapplication.di.components

import android.app.Application
import com.dacodes.myapplication.App
import com.dacodes.myapplication.di.components.viewModels.ViewModelFactoryModule
import com.dacodes.myapplication.di.modules.ActivitiesModule
import com.dacodes.myapplication.di.modules.AppModule
import com.dacodes.myapplication.di.modules.NetworkModule
import com.dacodes.myapplication.di.modules.RepositoriesModule
import com.dacodes.myapplication.repository.CocktailRepository
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ViewModelFactoryModule::class,
        NetworkModule::class,
        ActivitiesModule::class,
        AppModule::class,
        RepositoriesModule::class
    ]
)

interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)

    fun inject(cocktailRepository: CocktailRepository)

}