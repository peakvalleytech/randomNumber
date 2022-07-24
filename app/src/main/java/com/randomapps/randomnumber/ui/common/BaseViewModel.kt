package com.randomapps.randomnumber.ui.common

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {
    protected val _stateFlow = MutableStateFlow<ViewState?>(null)
    val stateFlow = _stateFlow.asStateFlow()

    protected val _effectFlow = MutableStateFlow<ViewEffect?>(null)
    val effectFlow = _effectFlow.asStateFlow()

    abstract fun handleIntent(intent: Intent)
}