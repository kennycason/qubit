package com.kennycason.qubit.chip.wire

import com.kennycason.qubit.bit.Bit
import com.kennycason.qubit.chip.Chip
import com.kennycason.qubit.chip.Flow
import com.kennycason.qubit.chip.Node
import java.util.*

// pass flow immediately through wires
class Wire(val ascii: Char,
           chip: Chip,
           x: Int,
           y: Int) : Node(chip, x, y) {

    override fun handle() {}

    override fun receive(bit: Bit, flow: Flow) {
        when (ascii) {
            '└' -> {
                when (flow) {
                    Flow.DOWN -> emit(bit, Flow.RIGHT)
                    Flow.LEFT -> emit(bit, Flow.UP)
                }
            }
            '┐' -> {
                when (flow) {
                    Flow.RIGHT -> emit(bit, Flow.DOWN)
                    Flow.UP -> emit(bit, Flow.LEFT)
                }
            }
            '┘' -> {
                when (flow) {
                    Flow.RIGHT -> emit(bit, Flow.UP)
                    Flow.DOWN -> emit(bit, Flow.LEFT)
                }
            }
            '┌' -> {
                when (flow) {
                    Flow.LEFT -> emit(bit, Flow.DOWN)
                    Flow.UP -> emit(bit, Flow.RIGHT)
                }
            }
            '┼' -> {
                when (flow) {
                    Flow.LEFT -> emit(bit, Flow.LEFT)
                    Flow.RIGHT -> emit(bit, Flow.RIGHT)
                    Flow.UP -> emit(bit, Flow.UP)
                    Flow.DOWN -> emit(bit, Flow.DOWN)
                }
            }
            '│' -> {
                when (flow) {
                    Flow.DOWN -> emit(bit, Flow.DOWN)
                    Flow.UP -> emit(bit, Flow.UP)
                }
            }
            '─' -> {
                when (flow) {
                    Flow.LEFT -> emit(bit, Flow.LEFT)
                    Flow.RIGHT -> emit(bit, Flow.RIGHT)
                }
            }
            '┴' -> {
                when (flow) {
                    Flow.LEFT -> {
                        emit(bit, Flow.UP)
                        emit(bit, Flow.LEFT)
                    }
                    Flow.RIGHT -> {
                        emit(bit, Flow.UP)
                        emit(bit, Flow.RIGHT)
                    }
                    Flow.DOWN -> {
                        emit(bit, Flow.LEFT)
                        emit(bit, Flow.RIGHT)
                    }
                }
            }
            '┬' -> {
                when (flow) {
                    Flow.LEFT -> {
                        emit(bit, Flow.DOWN)
                        emit(bit, Flow.LEFT)
                    }
                    Flow.RIGHT -> {
                        emit(bit, Flow.DOWN)
                        emit(bit, Flow.RIGHT)
                    }
                    Flow.UP -> {
                        emit(bit, Flow.LEFT)
                        emit(bit, Flow.RIGHT)
                    }
                }
            }
            '├' -> {
                when (flow) {
                    Flow.LEFT -> {
                        emit(bit, Flow.UP)
                        emit(bit, Flow.DOWN)
                    }
                    Flow.UP -> {
                        emit(bit, Flow.UP)
                        emit(bit, Flow.RIGHT)
                    }
                    Flow.DOWN -> {
                        emit(bit, Flow.RIGHT)
                        emit(bit, Flow.DOWN)
                    }
                }
            }
            '┤' -> {
                when (flow) {
                    Flow.RIGHT -> {
                        emit(bit, Flow.UP)
                        emit(bit, Flow.DOWN)
                    }
                    Flow.UP -> {
                        emit(bit, Flow.UP)
                        emit(bit, Flow.LEFT)
                    }
                    Flow.DOWN -> {
                        emit(bit, Flow.LEFT)
                        emit(bit, Flow.DOWN)
                    }
                }
            }
        }
    }

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

    override fun toString() = ascii.toString()

}