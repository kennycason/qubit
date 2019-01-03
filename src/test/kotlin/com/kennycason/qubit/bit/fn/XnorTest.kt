package com.kennycason.qubit.bit.fn

import com.kennycason.qubit.bit.Bit
import com.kennycason.qubit.bit.fn.composite.Xnor
import junit.framework.Assert.assertFalse
import org.junit.Test
import kotlin.test.assertEquals


class XnorTest {

    // 2 value logic
    @Test
    fun binary() {
        val xnor = Xnor()

        assertEquals(Bit(true), xnor.apply(Bit(false), Bit(false)))
        assertEquals(Bit(false), xnor.apply(Bit(false), Bit(true)))
        assertEquals(Bit(false), xnor.apply(Bit(true), Bit(false)))
        assertEquals(Bit(true), xnor.apply(Bit(true), Bit(true)))
    }

    // 4 value logic
    @Test
    fun quad() {
        val xnor = Xnor()

        assertEquals(Bit(true, false), xnor.apply(Bit(false, true), Bit(false, false)))
        assertEquals(Bit(true, true), xnor.apply(Bit(false, true), Bit(false, true)))
        assertEquals(Bit(false, false), xnor.apply(Bit(false, true), Bit(true, false)))
        assertEquals(Bit(false, true), xnor.apply(Bit(false, true), Bit(true, true)))

        assertEquals(Bit(false, true), xnor.apply(Bit(true, false), Bit(false, false)))
        assertEquals(Bit(false, false), xnor.apply(Bit(true, false), Bit(false, true)))
        assertEquals(Bit(true, true), xnor.apply(Bit(true, false), Bit(true, false)))
        assertEquals(Bit(true, false), xnor.apply(Bit(true, false), Bit(true, true)))

        assertEquals(Bit(true, true), xnor.apply(Bit(false, false), Bit(false, false)))
        assertEquals(Bit(true, false), xnor.apply(Bit(false, false), Bit(false, true)))
        assertEquals(Bit(false, true), xnor.apply(Bit(false, false), Bit(true, false)))
        assertEquals(Bit(false, false), xnor.apply(Bit(false, false), Bit(true, true)))

        assertEquals(Bit(false, false), xnor.apply(Bit(true, true), Bit(false, false)))
        assertEquals(Bit(false, true), xnor.apply(Bit(true, true), Bit(false, true)))
        assertEquals(Bit(true, false), xnor.apply(Bit(true, true), Bit(true, false)))
        assertEquals(Bit(true, true), xnor.apply(Bit(true, true), Bit(true, true)))
    }

}