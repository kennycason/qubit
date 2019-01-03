package com.kennycason.qubit.bit.fn.composite

import com.kennycason.qubit.bit.Bit
import com.kennycason.qubit.bit.fn.BinaryFunction
import com.kennycason.qubit.bit.fn.Not
import com.kennycason.qubit.bit.fn.Xor
import java.util.*


class Xnor : BinaryFunction {
    private val xor = Xor()
    private val not = Not()

    override fun apply(a: Bit, b: Bit) : Bit {
        return not.apply(xor.apply(a, b))
    }


}