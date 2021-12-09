package com.randomapps.randomnumber.ui.common

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

abstract class BaseViewModel : ViewModel() {
    protected val _viewState = MutableSharedFlow<ViewState>()
    val viewState = _viewState.asSharedFlow()

    abstract fun handleIntent(intent: Intent)
}