package com.randomapps.randomnumber.ui.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.randomapps.randomgenerator.domain.models.NumberGenerator
import com.randomapps.randomnumber.ui.screens.generator.intents.GenerateNumber
import com.randomapps.randomnumber.ui.theme.RandomNumberTheme

@Composable
fun NumberGeneratorView(
    numberGenerator : NumberGenerator,
    onGenerateNumber : () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier,
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Text(
                numberGenerator.name,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
            )
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
                ) {
                Column(modifier = Modifier
                    .width(138.dp)
                    .background(Color.LightGray)
                    .padding(8.dp)) {
                    Text("From", color = Color.Gray)
                    Text(numberGenerator.from.toString())
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column(modifier = Modifier
                    .width(138.dp)
                    .background(Color.LightGray)
                    .padding(8.dp)) {
                    Text("To", color = Color.Gray)
                    Text(numberGenerator.to.toString())
                }
                Spacer(modifier = Modifier.width(8.dp))
                IconButton(onClick = {
                    onGenerateNumber()
                }, Modifier.width(54.dp).height(54.dp).background(MaterialTheme.colors.primary)) {
                    Icon(Icons.Default.PlayArrow
                    , contentDescription = "Generate Number")
                }
            }
        }
    }
}

@Preview
@Composable
fun NumberGeneratorViewPreview() {
    RandomNumberTheme() {
        NumberGeneratorView(
            numberGenerator = NumberGenerator(1, "Test generator preview", 1, 10),
            onGenerateNumber = {},
            modifier = Modifier
                .width(700.dp)
                .padding(16.dp)
        )
    }
}

@Preview
@Composable
fun NumberGeneratorViewLargePreview() {
    RandomNumberTheme() {
        NumberGeneratorView(
            numberGenerator = NumberGenerator(1, "Test generator preview", 1, 10),
            onGenerateNumber = {},
            modifier = Modifier
                .width(1200.dp)
                .padding(16.dp)
        )
    }
}