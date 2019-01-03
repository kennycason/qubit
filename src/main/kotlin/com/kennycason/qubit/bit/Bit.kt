package com.kennycason.qubit.bit

import java.util.*


class Bit(nbits: Int) {

    constructor(vararg initialState: Boolean) : this(initialState.size) {
        (0.. initialState.size - 1).forEach { i ->
            state[i] = initialState[i]
        }
    }

    val state: BooleanArray = BooleanArray(nbits)

    val size: Int by lazy { state.size }

    override fun equals(other: Any?): Boolean {
        if (other is Bit) {
            return Arrays.equals(state, other.state)
        }
        return false
    }
}