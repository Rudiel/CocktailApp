package com.dacodes.myapplication.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import javax.inject.Inject

open class BaseViewModel @Inject constructor(application: Application) :
    AndroidViewModel(application)