package com.randomapps.randomgenerator.domain.usecase

import com.randomapps.randomgenerator.domain.models.NumberGenerator

interface AddGeneratorUseCase {
    fun add(generator : NumberGenerator)
}