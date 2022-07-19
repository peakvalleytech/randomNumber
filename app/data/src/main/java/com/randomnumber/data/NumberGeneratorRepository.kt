package com.randomnumber.data

import com.randomapps.randomgenerator.domain.data.GeneratorRepository
import com.randomapps.randomgenerator.domain.models.NumberGenerator

class NumberGeneratorStubRepository : GeneratorRepository {
    val data : MutableList<NumberGenerator> = mutableListOf()
    override fun create(generator: NumberGenerator) {
        generator.id = data.size.toLong() + 1
        data.add(generator)
    }

    override fun getAll(): List<NumberGenerator> {
        return data
    }


    override fun delete(generator: NumberGenerator) {
        data.remove(generator)
    }
}