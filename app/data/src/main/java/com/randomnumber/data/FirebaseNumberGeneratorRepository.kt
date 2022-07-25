package com.randomnumber.data

import android.util.Log
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.randomapps.randomgenerator.domain.data.GeneratorRepository
import com.randomapps.randomgenerator.domain.models.NumberGenerator
import com.randomnumber.data.models.TestData

class FirebaseNumberGeneratorRepository : GeneratorRepository {
    private var database : FirebaseDatabase
    init {
        database = Firebase.database
        val generators = database.reference.child("generators").get().addOnSuccessListener {
            Log.d("firebase", "Got value ${it.value}")

            database.reference.child("generators").setValue(TestData("1", "testdata"))
        }
    }
    override fun create(generator: NumberGenerator) {

    }

    override fun getAll(): List<NumberGenerator> {
        return listOf()
    }

    override fun delete(generator: NumberGenerator) {
    }
}