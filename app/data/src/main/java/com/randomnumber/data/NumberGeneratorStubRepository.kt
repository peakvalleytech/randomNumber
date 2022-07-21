package com.randomnumber.data

import com.randomapps.randomgenerator.domain.data.GeneratorRepository
import com.randomapps.randomgenerator.domain.models.NumberGenerator

class NumberGeneratorStubRepository : GeneratorRepository {
    val data : MutableList<NumberGenerator> = mutableListOf()

    init {
        val numberGenerator1 : NumberGenerator = NumberGenerator(1, "Generator 1", 1, 10)
        val numberGenerator2 : NumberGenerator = NumberGenerator(2, "Generator 2", 2, 20)
        val numberGenerator3 : NumberGenerator = NumberGenerator(3, "Generator 3", 3, 30)
        val numberGenerator4 : NumberGenerator = NumberGenerator(4, "Generator 4", 4, 40)
        data.add(numberGenerator1)
        data.add(numberGenerator2)
        data.add(numberGenerator3)
        data.add(numberGenerator4)
    }

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