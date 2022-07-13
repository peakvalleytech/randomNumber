package com.randomapps.randomnumber.ui.common.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NumberGenerator(title : String, from : Int = 1, to : Int = 10, modifier: Modifier) {
    Column(modifier) {
        Text(title)
        Text("From $from")
        Text("To $to")
    }
}

@Preview
@Composable
fun NumberGeneratorPreview() {
    NumberGenerator(
        title = "Test generator",
        modifier =
        Modifier
            .width(760.dp)
            .wrapContentHeight()
            .padding(16.dp))
}