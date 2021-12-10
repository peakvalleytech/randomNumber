package com.randomapps.randomnumber.ui.screens.generator

import androidx.lifecycle.viewModelScope
import com.randomapps.randomgenerator.domain.usecase.GenerateNumberUseCase
import com.randomapps.randomgenerator.domain.usecase.impl.GenerateNumberUseCaseImpl
import com.randomapps.randomnumber.ui.common.BaseViewModel
import com.randomapps.randomnumber.ui.common.Intent
import com.randomapps.randomnumber.ui.common.ViewState
import com.randomapps.randomnumber.ui.screens.generator.intents.GenerateNumber
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class GeneratorViewModel(val generateNumberUseCase : GenerateNumberUseCase = GenerateNumberUseCaseImpl()) : BaseViewModel() {
    override fun handleIntent(intent: Intent) {
        when (intent) {
            is GenerateNumber -> {
                viewModelScope.launch {
                    try {
//                        generateNumberUseCase.generateNumber()
                        _viewState.emit(GeneratorViewState.Start())
                    } catch (e: IllegalArgumentException) {
                        _viewState.emit(GeneratorViewState.Error("Invalid range."))
                    }
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