package com.randomapps.randomnumber.ui.screens.generator

import androidx.lifecycle.viewModelScope
import com.randomapps.randomgenerator.domain.usecase.GenerateNumberUseCase
import com.randomapps.randomnumber.ui.common.BaseViewModel
import com.randomapps.randomnumber.ui.common.Intent
import com.randomapps.randomnumber.ui.common.ViewState
import com.randomapps.randomnumber.ui.screens.generator.intents.GenerateNumber
import com.randomapps.randomnumber.ui.screens.generator.intents.UpdateFrom
import com.randomapps.randomnumber.ui.screens.generator.intents.UpdateTo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GeneratorViewModel @Inject constructor(val generateNumberUseCase : GenerateNumberUseCase) : BaseViewModel() {

    private var number : String = ""
    private var from : Int = 0
    private var to : Int = 0

    override fun handleIntent(intent: Intent) {
        when (intent) {
            is GenerateNumber -> {
                viewModelScope.launch {
                    try {
                        val from = intent.from
                        val to = intent.to
                        val number = generateNumberUseCase.generateNumber(from, to)
                        _stateFlow.emit(GeneratorViewState.Success(number.toString(), from, to))
                    } catch (e: IllegalArgumentException) {
                        _stateFlow.emit(GeneratorViewState.Error("Invalid range."))
                    }
                }
            }

            is UpdateFrom -> {
                val updateFrom = intent as UpdateFrom
                viewModelScope.launch {
                    try {
                        from = Integer.valueOf(updateFrom.from)
                        _stateFlow.emit(GeneratorViewState.Success(number, from, to))
                    } catch (nfe: NumberFormatException) {
                        _stateFlow.emit(GeneratorViewState.Error("Invalid number."))
                    }
                }
            }
            is UpdateTo -> {
                val updateTo = intent
                viewModelScope.launch {
                    try {
                        to = Integer.valueOf(updateTo.to)
                        _stateFlow.emit(GeneratorViewState.Success(number, from, to))
                    } catch (nfe: NumberFormatException) {
                        _stateFlow.emit(GeneratorViewState.Error("Invalid number."))
                    }
                }
            }

        }
    }

    fun load() {
        if (number.isEmpty()) {
            number = "--"
        }
        viewModelScope.launch {
                _stateFlow.emit(GeneratorViewState.Success(number, from, to))
        }
    }
}

sealed class GeneratorViewState : ViewState {
//    class Start(val text : String, val from : Int, val to : Int) : GeneratorViewState()
    class Success(val number : String, val from : Int, val to : Int) : GeneratorViewState()
    class Error(val msg : String) : GeneratorViewState()
}