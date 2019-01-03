package com.kennycason.qubit.circuit

import com.kennycason.cellular.automata.array2d
import com.kennycason.qubit.chip.Chip
import com.kennycason.qubit.chip.ChipLoader
import com.kennycason.qubit.chip.Emitter
import org.junit.Test


class ChipLoaderTest {

    @Test
    fun basic() {
        val chip = ChipLoader().load(
                "+─^─o\n" +
                "+─┘  ")
        println(chip)

        (0..10).forEach {
            chip.handle()
        }
        println()
    }
}