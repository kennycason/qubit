package com.kennycason.qubit.bit.fn.composite

import com.kennycason.qubit.bit.Bit
import com.kennycason.qubit.bit.fn.And
import com.kennycason.qubit.bit.fn.BinaryFunction
import com.kennycason.qubit.bit.fn.Not
import java.util.*


class Nand : BinaryFunction {
    private val and = And()
    private val not = Not()

    override fun apply(a: Bit, b: Bit) : Bit {
        return not.apply(and.apply(a, b))
    }

}