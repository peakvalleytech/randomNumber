package com.randomapps.randomnumber.ui.common

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel : ViewModel() {
    protected val _stateFlow = MutableStateFlow<ViewState?>(null)
    val stateFlow = _stateFlow.asStateFlow()

    abstract fun handleIntent(intent: Intent)
}