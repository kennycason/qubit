package com.kennycason.qubit.chip

import com.kennycason.cellular.automata.array2d
import com.sun.corba.se.impl.ior.WireObjectKeyTemplate
import java.util.*


class Chip(width: Int, height: Int) {

    val nodes: Array<Array<Node?>> = array2d(width, height, { null })

    fun width() = nodes.size

    fun height() = nodes.first().size

    fun handle() {
        (0.. width() - 1).forEach { x ->
            (0.. height() - 1).forEach { y ->
                nodes[x][y]?.handle()
            }
        }
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        (0.. height() - 1).forEach { y ->
            (0.. width() - 1).forEach { x ->
                stringBuilder.append(if (nodes[x][y] != null) {
                    nodes[x][y].toString()
                } else {
                    " "
                })
            }
            stringBuilder.append("\n")
        }

        return stringBuilder.toString()
    }

}

