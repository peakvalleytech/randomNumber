package com.randomapps.randomgenerator.domain.usecase.impl

import com.randomapps.randomgenerator.domain.data.GeneratorRepository
import com.randomapps.randomgenerator.domain.models.NumberGenerator
import com.randomapps.randomgenerator.domain.usecase.AddGeneratorUseCase

class AddGeneratorUseCaseImpl(
    val repository: GeneratorRepository
) : AddGeneratorUseCase {
    override fun add(generator: NumberGenerator) {
         repository.create(generator)
    }
}