package com.randomapps.randomgenerator.domain.models

data class NumberGenerator(
    var id : Long = 0,
    var name : String,
    var from : Int,
    var to : Int
)