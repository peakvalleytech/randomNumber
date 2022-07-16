package com.randomapps.randomgenerator.domain.data

import com.randomapps.randomgenerator.domain.models.NumberGenerator

interface GeneratorRepository {
    fun create(generator: NumberGenerator)
    fun getAll()
    fun delete(generator: NumberGenerator)
}