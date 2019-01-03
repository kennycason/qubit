package com.kennycason.qubit.bit.fn.composite

import com.kennycason.qubit.bit.Bit
import com.kennycason.qubit.bit.fn.BinaryFunction
import com.kennycason.qubit.bit.fn.Not
import com.kennycason.qubit.bit.fn.Or
import java.util.*


class Nor : BinaryFunction {
    private val or = Or()
    private val not = Not()

    override fun apply(a: Bit, b: Bit) : Bit {
        return not.apply(or.apply(a, b))
    }

}