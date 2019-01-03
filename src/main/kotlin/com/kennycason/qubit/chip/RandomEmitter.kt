package com.kennycason.qubit.chip

import com.kennycason.qubit.bit.Bit
import com.kennycason.qubit.bit.fn.BinaryFunction

/**
 * Emitters emit a constant signal
 *
 */
class RandomEmitter(chip: Chip,
              x: Int,
              y: Int,
              var state: Bit = Bit(true, true)) : Node(chip, x, y) {

    override fun receive(bit: Bit, flow: Flow) {
        state = bit
    }

    override fun handle() {
        if (x + 1 < chip.width()) {
            chip.nodes[x + 1][y]?.receive(state, Flow.RIGHT)
        }
        if (x > 0) {
            chip.nodes[x - 1][y]?.receive(state, Flow.LEFT)
        }
        if (y + 1 < chip.height()) {
            chip.nodes[x][y + 1]?.receive(state, Flow.DOWN)
        }
        if (y > 0) {
            chip.nodes[x][y - 1]?.receive(state, Flow.UP)
        }
    }

    override fun toString() = "+"
}
