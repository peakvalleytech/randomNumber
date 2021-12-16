package com.randomapps.randomnumber.ui.screens.generator

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.randomapps.randomnumber.ui.common.component.AppTextField
import com.randomapps.randomnumber.ui.screens.generator.intents.GenerateNumber

@Composable
fun GeneratorScreen(viewModel : GeneratorViewModel) {
    val viewState = viewModel.stateFlow
        .collectAsState()
    var numberState by remember { mutableStateOf("") }
    var fromTextState by remember { mutableStateOf(TextFieldValue(""))}
    var toTextState by remember { mutableStateOf(TextFieldValue(""))}
    val load = remember {viewModel.load()}
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {
        when (viewState.value) {
            is GeneratorViewState.Success -> {
                val state = viewState.value as GeneratorViewState.Success
                numberState = state.number
//                fromTextState = TextFieldValue(state.from.toString())
//                toTextState = TextFieldValue(state.to.toString())
            }
            is GeneratorViewState.Error -> {
                val state = viewState.value as GeneratorViewState.Error
//                fromTextState = TextFieldValue(fromUpdated.from.toString())
            }
        }

        Text(numberState,
            style = MaterialTheme.typography.h1,
            modifier = Modifier.align(CenterHorizontally))
        Spacer(modifier = Modifier.height(16.dp))
        AppTextField(label = "From", value = fromTextState) { newText ->
            fromTextState = newText
//            viewModel.handleIntent(UpdateFrom(newText.text))

        }
        Spacer(modifier = Modifier.height(16.dp))
        AppTextField(label = "To", value = toTextState) { newText ->
            toTextState = newText
//            viewModel.handleIntent(UpdateTo(newText.text))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                      viewModel.handleIntent(GenerateNumber(fromTextState.text.toInt(), toTextState.text.toInt()))
            },
            modifier = Modifier.align(CenterHorizontally)
        ) {Text("Next")}

    }
}

@Preview
@Composable
fun GeneratorScreenPreview() {
//    GeneratorScreen()
}