package com.kennycason.qubit.chip

import com.kennycason.qubit.bit.Bit
import com.kennycason.qubit.bit.fn.BinaryFunction

/**
 * A gate accepts input (i) from RIGHT, and UP and emits outputs (o) to the RIGHT.
 *
 * Example And Gate
 * i1  ─^─ o
 * i2  ─┘

 *
 * Example Nand Gate
 * i1  ─^¬─ o
 * i2  ─┘
 *
 */
class BinaryGate(private val fn: BinaryFunction,
                 chip: Chip,
                 x: Int,
                 y: Int) : Node(chip, x, y) {

    private var state: Bit = Bit(false, false)

    private var inputs = Array<Bit>(2, { Bit(false, false) })

    override fun receive(bit: Bit, flow: Flow) {
        when (flow) {
            Flow.UP, Flow.DOWN -> inputs[1] = bit
            Flow.RIGHT -> inputs[0] = bit
        }
    }

    override fun handle() {
        state = fn.apply(inputs[0], inputs[1])
        if (x + 1 < chip.width()) {
            chip.nodes[x + 1][y]?.receive(state, Flow.RIGHT)
        }
    }

    override fun toString() = fn.toString()

}