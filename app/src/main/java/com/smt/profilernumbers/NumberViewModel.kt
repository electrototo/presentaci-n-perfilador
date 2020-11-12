package com.smt.profilernumbers

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class NumberViewModel : ViewModel() {
    val numbers: MutableList<Int> = mutableListOf()

    init {
        for (i in 0 until 100) {
            numbers.add(Random.nextInt(200))
        }
    }

    fun sort() {
    }
}