package com.randomapps.randomgenerator.domain.data

import com.randomapps.randomgenerator.domain.models.NumberGenerator

interface GeneratorRepository {
    fun create(generator: NumberGenerator)
    fun getAll() : List<NumberGenerator>
    fun delete(generator: NumberGenerator)
}