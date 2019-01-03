package com.kennycason.qubit.bit.fn

import com.kennycason.qubit.bit.Bit
import junit.framework.Assert.assertFalse
import org.junit.Test
import kotlin.test.assertEquals


class OrTest {

    // 2 value logic
    @Test
    fun binary() {
        val or = Or()

        assertEquals(Bit(false), or.apply(Bit(false), Bit(false)))
        assertEquals(Bit(true), or.apply(Bit(false), Bit(true)))
        assertEquals(Bit(true), or.apply(Bit(true), Bit(false)))
        assertEquals(Bit(true), or.apply(Bit(true), Bit(true)))
    }

    // 4 value logic
    @Test
    fun quad() {
        val or = Or()

        assertEquals(Bit(false, true), or.apply(Bit(false, true), Bit(false, false)))
        assertEquals(Bit(false, true), or.apply(Bit(false, true), Bit(false, true)))
        assertEquals(Bit(true, true), or.apply(Bit(false, true), Bit(true, false)))
        assertEquals(Bit(true, true), or.apply(Bit(false, true), Bit(true, true)))

        assertEquals(Bit(true, false), or.apply(Bit(true, false), Bit(false, false)))
        assertEquals(Bit(true, true), or.apply(Bit(true, false), Bit(false, true)))
        assertEquals(Bit(true, false), or.apply(Bit(true, false), Bit(true, false)))
        assertEquals(Bit(true, true), or.apply(Bit(true, false), Bit(true, true)))

        assertEquals(Bit(false, false), or.apply(Bit(false, false), Bit(false, false)))
        assertEquals(Bit(false, true), or.apply(Bit(false, false), Bit(false, true)))
        assertEquals(Bit(true, false), or.apply(Bit(false, false), Bit(true, false)))
        assertEquals(Bit(true, true), or.apply(Bit(false, false), Bit(true, true)))

        assertEquals(Bit(true, true), or.apply(Bit(true, true), Bit(false, false)))
        assertEquals(Bit(true, true), or.apply(Bit(true, true), Bit(false, true)))
        assertEquals(Bit(true, true), or.apply(Bit(true, true), Bit(true, false)))
        assertEquals(Bit(true, true), or.apply(Bit(true, true), Bit(true, true)))
    }

}