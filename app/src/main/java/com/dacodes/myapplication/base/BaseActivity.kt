package com.dacodes.myapplication.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

open class BaseActivity : AppCompatActivity(), HasSupportFragmentInjector {


    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>


    override fun supportFragmentInjector() = dispatchingAndroidInjector
}
