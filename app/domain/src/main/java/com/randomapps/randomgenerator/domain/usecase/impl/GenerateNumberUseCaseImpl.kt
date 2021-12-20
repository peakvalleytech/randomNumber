package com.randomapps.randomgenerator.domain.usecase.impl

import com.randomapps.randomgenerator.domain.usecase.GenerateNumberUseCase
import kotlin.random.Random

class GenerateNumberUseCaseImpl : GenerateNumberUseCase {
    override fun generateNumber(from: Int, to: Int): Int {
        if (to >= from) {
            throw IllegalArgumentException()
        }
        val rand = Random(System.currentTimeMillis())
        val number =  rand.nextInt(from, to + 1)
        return number
    }
}