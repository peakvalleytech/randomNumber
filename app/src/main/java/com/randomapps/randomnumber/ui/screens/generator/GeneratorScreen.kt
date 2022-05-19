package com.randomapps.randomnumber.ui.screens.generator

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.randomapps.randomnumber.ui.common.component.AppTextField
import com.randomapps.randomnumber.ui.screens.generator.intents.GenerateNumber

@ExperimentalComposeUiApi
@Composable
fun GeneratorScreen(viewModel : GeneratorViewModel = hiltViewModel()) {
    val viewState = viewModel.stateFlow
        .collectAsState()
    var numberState by remember { mutableStateOf("") }
    var fromTextState by remember { mutableStateOf("")}
    var toTextState by remember { mutableStateOf("")}
    val scaffoldState = rememberScaffoldState()
    val keyboardController = LocalSoftwareKeyboardController.current

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
                   LaunchedEffect(scaffoldState.snackbarHostState) {
                       scaffoldState.snackbarHostState.showSnackbar(state.msg)
                    }
                }
            }

            Text(numberState,
                style = MaterialTheme.typography.h1,
                modifier = Modifier.align(CenterHorizontally))
            Spacer(modifier = Modifier.height(16.dp))
            AppTextField(label = "From", value = fromTextState) { newText ->
                fromTextState = newText
            }
            Spacer(modifier = Modifier.height(16.dp))
            AppTextField(label = "To", value = toTextState) { newText ->
                toTextState = newText
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    keyboardController?.hide()
                    viewModel.handleIntent(GenerateNumber(fromTextState, toTextState))
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