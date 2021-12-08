package com.randomapps.randomnumber.ui.common.component

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RandomNumberTopBar() {
    TopAppBar(
        title = {Text("Random Number")}
    )

}


@Preview
@Composable
fun RandomNumberTopBarPreview() {
    RandomNumberTopBar()
}