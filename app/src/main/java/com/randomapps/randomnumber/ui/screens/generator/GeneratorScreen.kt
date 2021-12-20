package com.randomapps.randomnumber.ui.screens.generator

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.randomapps.randomnumber.ui.common.component.AppTextField
import com.randomapps.randomnumber.ui.screens.generator.intents.GenerateNumber
import com.randomapps.randomnumber.ui.screens.generator.intents.InputIntent
import com.randomapps.randomnumber.ui.screens.generator.intents.UpdateRange

@Composable
fun GeneratorScreen(viewModel : GeneratorViewModel) {
    val viewState = viewModel.stateFlow.collectAsState()
    var numberState by remember { mutableStateOf("") }
    var range by remember {mutableStateOf(Pair(0, 0))}
    val scaffoldState = rememberScaffoldState()
    val focusManager = LocalFocusManager.current

    Scaffold(scaffoldState = scaffoldState) {
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()) {
            when (viewState.value) {
                is GeneratorViewState.Success -> {
                    val state = viewState.value as GeneratorViewState.Success
                    numberState = state.number
                }
                is GeneratorViewState.Error -> {
                    val state = viewState.value as GeneratorViewState.Error
                   LaunchedEffect(range) {
                       focusManager.clearFocus()
                       scaffoldState.snackbarHostState.showSnackbar(state.msg)
                       viewModel.handleIntent(InputIntent())
                    }
                }
                is GeneratorViewState.Input -> {
                    val state = viewState.value as GeneratorViewState.Input
                    numberState = state.number
                    range = Pair(state.from, state.to)
                }
            }

            Text(numberState,
                style = MaterialTheme.typography.h1,
                modifier = Modifier.align(CenterHorizontally))
            Spacer(modifier = Modifier.height(16.dp))
            AppTextField(label = "From", value = range.first.toString()) { newLower ->
                viewModel.handleIntent(UpdateRange(newLower, range.second.toString()))
            }
            Spacer(modifier = Modifier.height(16.dp))
            AppTextField(label = "To", value = range.second.toString() ) { newUpper ->
                viewModel.handleIntent(UpdateRange(range.first.toString(), newUpper))
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    viewModel.handleIntent(GenerateNumber(range.first, range.second))
                },
                modifier = Modifier.align(CenterHorizontally)
            ) {Text("Next")}
        }
    }
}

@Preview
@Composable
fun GeneratorScreenPreview() {
//    GeneratorScreen()
}