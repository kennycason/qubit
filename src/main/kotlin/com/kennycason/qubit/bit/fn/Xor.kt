package com.kennycason.qubit.bit.fn

import com.kennycason.qubit.bit.Bit
import java.util.*


class Xor : BinaryFunction {
    override fun apply(a: Bit, b: Bit) : Bit {
        val c = Bit(a.size)
        (0.. a.size - 1).forEach { i ->
            c.state[i] = a.state[i] xor b.state[i]
        }
        return c
    }

    override fun toString() = "⊕"

}