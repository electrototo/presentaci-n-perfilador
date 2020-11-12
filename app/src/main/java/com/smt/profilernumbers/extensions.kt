package com.smt.profilernumbers

fun MutableList<Int>.bubbleSort() {
    for (i in 0 until this.size) {
        for (j in 0 until this.size - 1) {
            if (this[j] > this[j + 1]) {
                this.swap(j, j + 1)
            }
        }
    }
}

fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]

    this[index1] = this[index2]
    this[index2] = tmp
}