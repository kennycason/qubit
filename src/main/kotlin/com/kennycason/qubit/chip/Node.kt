package com.kennycason.qubit.chip

import com.kennycason.qubit.bit.Bit


abstract class Node(val chip: Chip,
                    val x: Int,
                    val y: Int) {

    // receive a bit of data, from a specific flow/direction
    abstract fun receive(bit: Bit, flow: Flow)

    abstract fun handle()

}