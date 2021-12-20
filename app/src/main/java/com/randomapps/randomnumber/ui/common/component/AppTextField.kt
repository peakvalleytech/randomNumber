package com.randomapps.randomnumber.ui.common.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppTextField(label: String, value: TextFieldValue, onValueChanged: (TextFieldValue) -> Unit) {
    Box(modifier = Modifier.fillMaxWidth()) {
    TextField(
        label = { Text(label) },
        value = value,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        onValueChange = {onValueChanged(it)},
        maxLines = 1,
        modifier = Modifier.align(Alignment.Center))

    }
}

@Preview
@Composable
fun AppTextFieldPreview() {
    Column(Modifier.width(600.dp)) {
        AppTextField("Label", TextFieldValue()) {}
    }
}