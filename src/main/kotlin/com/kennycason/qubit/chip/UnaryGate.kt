package com.kennycason.qubit.chip

import com.kennycason.qubit.bit.Bit
import com.kennycason.qubit.bit.fn.BinaryFunction
import com.kennycason.qubit.bit.fn.UnaryFunction

/**
 * A special gate accepts input (i) from any vertical/horizontal directoin and emits immediately
 *
 * Example And Gate
 * i1  ─¬─ o
 */
class UnaryGate(private val fn: UnaryFunction,
                chip: Chip,
                x: Int,
                y: Int) : Node(chip, x, y) {

    override fun receive(bit: Bit, flow: Flow) {
        when (flow) {
            Flow.RIGHT -> emit(fn.apply(bit), Flow.RIGHT)
            Flow.LEFT -> emit(fn.apply(bit), Flow.LEFT)
            Flow.UP -> emit(fn.apply(bit), Flow.UP)
            Flow.DOWN -> emit(fn.apply(bit), Flow.DOWN)
        }
    }

    override fun handle() {}

    // emit a bit of data, from a specific flow/direction
    private fun emit(bit: Bit, flow: Flow) {
        when (flow) {
            Flow.DOWN -> if (y + 1 < chip.height()) {
                chip.nodes[x][y + 1]?.receive(bit, flow)
            }
            Flow.UP -> if (y > 0) {
                chip.nodes[x][y - 1]?.receive(bit, flow)
            }
            Flow.LEFT -> if (x > 0) {
                chip.nodes[x - 1][y]?.receive(bit, flow)
            }
            Flow.RIGHT -> if (x + 1 < chip.width()) {
                chip.nodes[x + 1][y]?.receive(bit, flow)
            }
        }
    }

    override fun toString() = fn.toString()

}