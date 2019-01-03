package com.kennycason.qubit.chip

import com.kennycason.qubit.bit.Bit
import com.kennycason.qubit.bit.Bits
import java.awt.Color
import java.awt.Graphics
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.WindowConstants


fun main(args: Array<String>) {
    ChipViewer().run()
}

class ChipViewer {
    val chip = ChipLoader().load(
            "+─^─┬─o \n" +
            "+─┘ o   \n" +
            "        ")

    val cellDim = 25
    val width = chip.width() * cellDim
    val height = chip.height() * cellDim + 30
    val saveImage = false

    var canvas: BufferedImage = BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB)
    var graphics = canvas.createGraphics()

    fun run() {
        val frame = JFrame()
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
        frame.setSize(width, height)
        frame.setVisible(true)

        var i = 0
        val panel = object: JPanel() {
            override fun paintComponent(g: Graphics) {
                super.paintComponent(g)
                g.color = Color.BLACK
                g.fillRect(0, 0, width, height)

                chip.handle()

                draw(g, chip)
                g.drawImage(canvas, 0, 0, width, height, this)

                if (saveImage) {
                    ImageIO.write(canvas, "png", File("/tmp/t1.png"))
                }
                i++
                println(i)
            }
        }
        frame.add(panel)
        panel.revalidate()

        while (true) {
            panel.repaint()
            Thread.sleep(100)
        }
    }

    private fun draw(g: Graphics, chip: Chip) {
        (0.. chip.width() - 1).forEach { x ->
            (0.. chip.height() - 1).forEach { y ->
                val node = chip.nodes[x][y]
                if (node is Receiver) {
                    val color = getColor(node.state)
                    g.color = color
                    g.fillRect(x * cellDim, y * cellDim, cellDim, cellDim)
                }
            }
        }
    }

    private fun getColor(bit: Bit) = when (bit) {
        Bits.TRUE -> Color.WHITE
        Bits.FALSE -> Color.BLACK
        Bits.BOTH -> Color.BLUE
        Bits.NONE -> Color.RED
        else -> throw RuntimeException()
    }

}