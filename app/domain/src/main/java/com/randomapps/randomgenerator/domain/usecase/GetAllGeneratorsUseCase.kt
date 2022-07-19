package com.randomapps.randomgenerator.domain.usecase

import com.randomapps.randomgenerator.domain.models.NumberGenerator

interface GetAllGeneratorsUseCase {
    fun get() : List<NumberGenerator>
}
