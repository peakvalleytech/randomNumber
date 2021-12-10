package com.randomapps.randomnumber.ui.screens.generator

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.w3c.dom.Text

@Composable
fun GeneratorScreen(viewModel : GeneratorViewModel) {
    val viewState = viewModel.viewState
        .collectAsState(initial = GeneratorViewState.Start())

    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {
        when (viewState.value) {
            is GeneratorViewState.Start -> {
                val startState = viewState as GeneratorViewState.Start
                Text("--",
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.align(CenterHorizontally))
            }
            is GeneratorViewState.NumberGenerated -> {
                val numberGeneratedState = viewState as GeneratorViewState.NumberGenerated
                Text(numberGeneratedState.number.toString(),
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.align(CenterHorizontally))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            label = { Text("From")},
            value = "0",
            onValueChange = {},
            modifier = Modifier.align(CenterHorizontally))
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            label = { Text("To")},
            value = "0",
            onValueChange = {},
            modifier = Modifier.align(CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {},
            modifier = Modifier.align(CenterHorizontally)
        ) {Text("Next")}

    }
}

@Preview
@Composable
fun GeneratorScreenPreview() {
//    GeneratorScreen()
}