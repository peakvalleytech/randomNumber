package com.randomapps.randomnumber.ui.common.component

import androidx.compose.foundation.background
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.randomapps.randomnumber.R
import com.randomapps.randomnumber.ui.theme.blue400

@Composable
fun RandomNumberTopBar() {
    TopAppBar(
        title = {
            Text(
                stringResource(R.string.app_name),
                color = Color.White
            )
        },
        backgroundColor = blue400
    )

}


@Preview
@Composable
fun RandomNumberTopBarPreview() {
    RandomNumberTopBar()
}