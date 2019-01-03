package com.kennycason.qubit.bit.fn

import com.kennycason.qubit.bit.Bit


interface UnaryFunction {
    fun apply(a: Bit): Bit
}