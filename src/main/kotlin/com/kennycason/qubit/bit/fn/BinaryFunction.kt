package com.kennycason.qubit.bit.fn

import com.kennycason.qubit.bit.Bit


interface BinaryFunction {
    fun apply(a: Bit, b: Bit): Bit
}