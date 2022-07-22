package com.randomapps.randomnumber.ui.screens.generator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.SpaceEvenly
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.randomapps.randomgenerator.domain.models.NumberGenerator
import com.randomapps.randomnumber.R
import com.randomapps.randomnumber.ui.common.component.AppTextField
import com.randomapps.randomnumber.ui.common.component.NumberGenerator
import com.randomapps.randomnumber.ui.common.component.NumberGeneratorView
import com.randomapps.randomnumber.ui.screens.generator.intents.AddGeneratorIntent
import com.randomapps.randomnumber.ui.screens.generator.intents.GenerateNumber
import com.randomapps.randomnumber.ui.screens.generator.intents.ResetState
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@ExperimentalComposeUiApi
@Composable
fun GeneratorScreen(viewModel : GeneratorViewModel = hiltViewModel()) {
    val viewState = viewModel.stateFlow
        .collectAsState()
    var numberState by remember { mutableStateOf("") }
    var nameTextState by remember { mutableStateOf("")}
    var fromTextState by remember { mutableStateOf("")}
    var toTextState by remember { mutableStateOf("")}
    val scaffoldState = rememberScaffoldState()
    val keyboardController = LocalSoftwareKeyboardController.current

    val modalBottomSheetState = rememberModalBottomSheetState(initialValue =
(ModalBottomSheetValue.Hidden)
    )
    val scope = rememberCoroutineScope()
    Scaffold(scaffoldState = scaffoldState,
        floatingActionButton = {

        }
    ) {

//        LaunchedEffect(key1 = bottomSheetScaffoldState.bottomSheetState){
//            bottomSheetScaffoldState.bottomSheetState.expand()
//        }
        ModalBottomSheetLayout(
            sheetState = modalBottomSheetState,
            sheetContent = {

                Column(Modifier.padding(16.dp)) {
                    AppTextField(label = stringResource(R.string.name), value = nameTextState,
                    keyboardType = KeyboardType.Text) { newText ->
                        nameTextState = newText
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    AppTextField(label = stringResource(R.string.From), value = fromTextState) { newText ->
                        fromTextState = newText
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    AppTextField(label = stringResource(R.string.To), value = toTextState) { newText ->
                        toTextState = newText
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = {
                            viewModel.handleIntent(
                                AddGeneratorIntent(
                                    nameTextState,
                                    fromTextState,
                                    toTextState
                                )
                            )
                        },
                        colors = ButtonDefaults.buttonColors(contentColor = Color.White),
                        modifier =
                        Modifier
                            .align(CenterHorizontally)
                            .fillMaxWidth()
                    ) {Text(stringResource(R.string.add))}
                }
            }
        ) {
            Box(
                contentAlignment = Center,
                modifier =
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()) {
                var generators : List<NumberGenerator>? = null
                when (viewState.value) {
                    is GeneratorViewState.Success -> {
                        val state = viewState.value as GeneratorViewState.Success
                        numberState = state.number
                        generators = state.generators
                    }
                    is GeneratorViewState.Error -> {
                        val state = viewState.value as GeneratorViewState.Error
                        LaunchedEffect(scaffoldState.snackbarHostState) {
                            scaffoldState.snackbarHostState.showSnackbar(state.msg)
                            viewModel.handleIntent(ResetState())
                        }
                    }
                }
                Column(
                    modifier = Modifier
                        .align(TopCenter)
                        .background(Color.LightGray)
                        .fillMaxWidth()
                        .height(200.dp)) {
                    Text(numberState,
                        color = MaterialTheme.colors.primaryVariant,
                        style = MaterialTheme.typography.h1)
                }
                Spacer(modifier = Modifier.height(16.dp))
                Column(
                    Modifier
                        .background(Color.Gray)
                        .padding(16.dp)
                        .fillMaxWidth()
                        .height(444.dp)) {
                    LazyColumn(modifier =
                    Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()

                    ) {
                        item {
                            generators?.forEach {
                                NumberGeneratorView(
                                    numberGenerator = it,
                                    onGenerateNumber = {
                                        viewModel.handleIntent(GenerateNumber(it.from, it.to))
                                    }
                                    )
                                Spacer(modifier = Modifier.height(8.dp))
                            }
                        }
                    }
                }
                FloatingActionButton(onClick = {
                    scope.launch {
                        modalBottomSheetState.show()
                    }
                },
                    backgroundColor = MaterialTheme.colors.primary,
                modifier =
                Modifier
                    .align(BottomEnd)
                    .padding(end = 16.dp, bottom = 16.dp)
                ) {
                    Icon(imageVector = Icons.Default.Add, "Add generator")
                }
            }
        }
    }
}

@Preview
@Composable
fun GeneratorScreenPreview() {
//    GeneratorScreen()
}