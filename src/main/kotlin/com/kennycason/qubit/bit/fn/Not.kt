package com.kennycason.qubit.bit.fn

import com.kennycason.qubit.bit.Bit
import java.util.*


class Not : UnaryFunction {
    override fun apply(a: Bit) : Bit {
        val b = Bit(a.size)
        (0.. a.size - 1).forEach { i ->
            b.state[i] = !a.state[i]
        }
        return b
    }

    override fun toString() = "¬"

}