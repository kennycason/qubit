package com.kennycason.qubit.chip

import com.kennycason.qubit.bit.fn.And
import com.kennycason.qubit.bit.fn.Not
import com.kennycason.qubit.bit.fn.Or
import com.kennycason.qubit.bit.fn.Xor
import com.kennycason.qubit.chip.wire.Wire
import sun.java2d.loops.XORComposite


class ChipLoader {

    fun load(data: String) : Chip {
        val rows = data.split('\n')
        val height = rows.size
        val width = rows[0].length

        val chip = Chip(width, height)

        (0.. width - 1).forEach { x ->
            (0.. height - 1).forEach { y ->
                chip.nodes[x][y] = parseNode(rows[y][x], chip, x, y)
            }
        }
        return chip
    }

    private fun parseNode(c: Char, chip: Chip, x: Int, y: Int): Node? {
        return when (c) {
            '+' -> Emitter(chip, x, y)
            'o' -> Receiver(chip, x, y)
            '∨' -> BinaryGate(Or(), chip, x, y)
            '^' -> BinaryGate(And(), chip, x, y)
            '⊕' -> BinaryGate(Xor(), chip, x, y)
            '¬' -> UnaryGate(Not(), chip, x, y)
            '└', '┐', '┘', '┌', '┴', '┬', '├', '┼', '┤', '│', '─' -> Wire(c, chip, x, y)
            else -> null
        }
    }

}