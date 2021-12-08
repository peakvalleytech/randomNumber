package com.randomapps.randomnumber.ui.screens.generator

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GeneratorScreen() {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {

        Text("18",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.align(CenterHorizontally))
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
    GeneratorScreen()
}