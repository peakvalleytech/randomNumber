package com.randomapps.randomnumber.ui.screens.generator.intents

import com.randomapps.randomgenerator.domain.models.NumberGenerator
import com.randomapps.randomnumber.ui.common.Intent

class AddGeneratorIntent(
    val name : String,
    val from : String,
    val to : String
) : Intent {
}