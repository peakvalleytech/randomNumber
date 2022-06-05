package com.randomapps.randomnumber.ui.screens.generator

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.randomapps.randomgenerator.domain.usecase.GenerateNumberUseCase
import com.randomapps.randomnumber.R
import com.randomapps.randomnumber.ui.common.BaseViewModel
import com.randomapps.randomnumber.ui.common.Intent
import com.randomapps.randomnumber.ui.common.ViewState
import com.randomapps.randomnumber.ui.screens.generator.intents.GenerateNumber
import com.randomapps.randomnumber.ui.screens.generator.intents.ResetState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GeneratorViewModel @Inject constructor(val generateNumberUseCase : GenerateNumberUseCase,
                                             application: Application
) : BaseViewModel(application) {
    override fun handleIntent(intent: Intent) {
        when (intent) {
            is ResetState -> {
                viewModelScope.launch {
                    _stateFlow.emit(GeneratorViewState.DefaultState())
                }
            }
            is GenerateNumber -> {
                viewModelScope.launch {
                    try {
                        val from = intent.from.toInt()
                        val to = intent.to.toInt()
                        val number = generateNumberUseCase.generateNumber(from, to)
                        _stateFlow.emit(GeneratorViewState.Success(number.toString(), from, to))
                    } catch (e: IllegalArgumentException) {
                        _stateFlow.emit(GeneratorViewState.Error(getApplication<Application>().getString(R.string.error_invalid_range)))
                    } catch (e: java.lang.NumberFormatException) {
                         _stateFlow.emit(GeneratorViewState.Error("Not a valid range"))
                    }
                }
            }
        }
    }
}

sealed class GeneratorViewState : ViewState {
    class DefaultState() : GeneratorViewState()
    class Success(val number : String, val from : Int, val to : Int) : GeneratorViewState()
    class Error(val msg : String) : GeneratorViewState()
}