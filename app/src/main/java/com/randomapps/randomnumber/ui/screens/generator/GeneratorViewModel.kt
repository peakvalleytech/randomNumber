package com.randomapps.randomnumber.ui.screens.generator

import androidx.lifecycle.viewModelScope
import com.randomapps.randomnumber.ui.common.BaseViewModel
import com.randomapps.randomnumber.ui.common.Intent
import com.randomapps.randomnumber.ui.common.ViewState
import com.randomapps.randomnumber.ui.screens.generator.intents.GenerateNumber
import kotlinx.coroutines.launch

class GeneratorViewModel : BaseViewModel() {

    override fun handleIntent(intent: Intent) {
        when (intent) {
            is GenerateNumber -> {
                viewModelScope.launch {
                    _viewState.emit(GeneratorViewState.NumberGenerated(0))
                }
            }
        }
    }

}

sealed class GeneratorViewState : ViewState {
    class Start() : GeneratorViewState()
    class NumberGenerated(val number : Int) : GeneratorViewState()
    class Error(val msg : String) : GeneratorViewState()
}