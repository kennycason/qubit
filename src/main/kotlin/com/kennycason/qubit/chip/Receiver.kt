package com.kennycason.qubit.chip

import com.kennycason.qubit.bit.Bit
import com.kennycason.qubit.bit.fn.BinaryFunction

/**
 * Receiver receives and captures a signal
 *
 */
class Receiver(chip: Chip,
              x: Int,
              y: Int,
              var state: Bit = Bit(false, false)) : Node(chip, x, y) {

    override fun receive(bit: Bit, flow: Flow) {
        state = bit
    }

    override fun handle() {}

    override fun toString() = "o"
}
