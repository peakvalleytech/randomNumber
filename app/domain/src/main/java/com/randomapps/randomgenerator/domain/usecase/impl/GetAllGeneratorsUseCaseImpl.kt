package com.randomapps.randomgenerator.domain.usecase.impl

import com.randomapps.randomgenerator.domain.data.GeneratorRepository
import com.randomapps.randomgenerator.domain.models.NumberGenerator
import com.randomapps.randomgenerator.domain.usecase.GetAllGeneratorsUseCase

class GetAllGeneratorsUseCaseImpl(
    val repository: GeneratorRepository
) : GetAllGeneratorsUseCase {
    override fun get(): List<NumberGenerator> {
        return repository.getAll()
    }
}