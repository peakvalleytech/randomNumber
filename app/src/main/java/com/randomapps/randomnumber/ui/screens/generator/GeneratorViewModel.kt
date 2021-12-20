package com.randomapps.randomnumber.ui.screens.generator

import androidx.lifecycle.viewModelScope
import com.randomapps.randomgenerator.domain.usecase.GenerateNumberUseCase
import com.randomapps.randomgenerator.domain.usecase.impl.GenerateNumberUseCaseImpl
import com.randomapps.randomnumber.ui.common.BaseViewModel
import com.randomapps.randomnumber.ui.common.Intent
import com.randomapps.randomnumber.ui.common.ViewState
import com.randomapps.randomnumber.ui.screens.generator.intents.GenerateNumber
import com.randomapps.randomnumber.ui.screens.generator.intents.InputIntent
import com.randomapps.randomnumber.ui.screens.generator.intents.UpdateRange
import kotlinx.coroutines.launch
import kotlin.random.Random

class GeneratorViewModel(val generateNumberUseCase : GenerateNumberUseCase = GenerateNumberUseCaseImpl()) : BaseViewModel() {
    private var number : String = "--"
    private var from : Int = 0
    private var to : Int = 0
    init {
        viewModelScope.launch {
            _stateFlow.emit(GeneratorViewState.Input(number, from, to))
        }
    }
    override fun handleIntent(intent: Intent) {
        when (intent) {
            is GenerateNumber -> {
                viewModelScope.launch {
                    try {
                        number = generateNumberUseCase.generateNumber(from, to).toString()
                        _stateFlow.emit(GeneratorViewState.Success(number, from, to))
                    } catch (e: IllegalArgumentException) {
                        _stateFlow.emit(GeneratorViewState.Error("Invalid range."))
                    }
                }
            }
            is InputIntent -> {
                viewModelScope.launch {
                    _stateFlow.emit(GeneratorViewState.Input(number, from, to))
                }
            }
            is UpdateRange -> {
                viewModelScope.launch {
                    number = "--"
                    from = Integer.valueOf(intent.from)
                    to = Integer.valueOf(intent.to)
                    _stateFlow.emit(GeneratorViewState.Input(number, from, to))
                }
            }
        }
    }
}

sealed class GeneratorViewState : ViewState {
    class Input(val number : String, val from : Int, val to : Int) : GeneratorViewState()
    class Success(val number : String, val from : Int, val to : Int) : GeneratorViewState()
    class Error(val msg : String) : GeneratorViewState()
}