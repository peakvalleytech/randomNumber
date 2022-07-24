package com.randomapps.randomnumber.ui.screens.generator

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.randomapps.randomgenerator.domain.models.NumberGenerator
import com.randomapps.randomgenerator.domain.usecase.AddGeneratorUseCase
import com.randomapps.randomgenerator.domain.usecase.GenerateNumberUseCase
import com.randomapps.randomgenerator.domain.usecase.GetAllGeneratorsUseCase
import com.randomapps.randomnumber.R
import com.randomapps.randomnumber.ui.common.BaseViewModel
import com.randomapps.randomnumber.ui.common.Intent
import com.randomapps.randomnumber.ui.common.ViewEffect
import com.randomapps.randomnumber.ui.common.ViewState
import com.randomapps.randomnumber.ui.screens.generator.intents.AddGeneratorIntent
import com.randomapps.randomnumber.ui.screens.generator.intents.GenerateNumber
import com.randomapps.randomnumber.ui.screens.generator.intents.ResetState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GeneratorViewModel @Inject constructor(
    val addGeneratorUseCase: AddGeneratorUseCase,
    val getAllGeneratorsUseCase: GetAllGeneratorsUseCase,
    val generateNumberUseCase : GenerateNumberUseCase,
                                             application: Application
) : BaseViewModel(application) {
    private var generators : MutableList<NumberGenerator> = mutableListOf()
    init {
        viewModelScope.launch {
            generators = getAllGeneratorsUseCase.get().toMutableList()
            _stateFlow.emit(GeneratorViewState.Success("", generators))
        }
    }
    override fun handleIntent(intent: Intent) {
        when (intent) {
            is ResetState -> {
                viewModelScope.launch {
                    _stateFlow.emit(GeneratorViewState.DefaultState())
                }
            }
            is GenerateNumber -> {
                viewModelScope.launch {

                }
            }
            is AddGeneratorIntent -> {
                viewModelScope.launch {
                    try {
                        val newGenerateor = NumberGenerator(
                            name =  intent.name,
                            from = intent.from.toInt(),
                            to = intent.to.toInt()
                        )
                        generators.add(newGenerateor)
                        addGeneratorUseCase.add(newGenerateor)
                        _effectFlow.emit(GeneratorViewEffect.GeneratorAdded())
                        _stateFlow.emit(GeneratorViewState.Success("", generators))

                    } catch (e: IllegalArgumentException) {
                        _effectFlow.emit(GeneratorViewEffect.Error(getApplication<Application>().getString(R.string.error_invalid_range)))
                    } catch (e: java.lang.NumberFormatException) {
                        _effectFlow.emit(GeneratorViewEffect.Error("Not a valid range"))

                    }
                }
            }
        }
    }

    fun resetEffect() {
        _effectFlow.value = null
    }
}

sealed class GeneratorViewState : ViewState {
    class DefaultState() : GeneratorViewState()
    class Success(
        val number : String,
        val generators : List<NumberGenerator>
    ) : GeneratorViewState()
    class Error(val msg : String) : GeneratorViewState()
}

sealed class GeneratorViewEffect : ViewEffect {
    class Error(
        val msg : String
    ) : GeneratorViewEffect()
    class GeneratorAdded() : GeneratorViewEffect()
}