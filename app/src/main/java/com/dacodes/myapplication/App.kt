package com.dacodes.myapplication

import android.app.Activity
import android.app.Application
import com.dacodes.myapplication.di.components.AppComponent
import com.dacodes.myapplication.di.components.AppInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = AppInjector.init(this)
    }

    override fun activityInjector() = dispatchingAndroidInjector


}