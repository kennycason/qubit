package com.kennycason.qubit.bit.fn

import com.kennycason.qubit.bit.Bit
import junit.framework.Assert.assertFalse
import org.junit.Test
import kotlin.test.assertEquals


class AndTest {

    // 2 value logic
    @Test
    fun binary() {
        val and = And()

        assertEquals(Bit(false), and.apply(Bit(false), Bit(false)))
        assertEquals(Bit(false), and.apply(Bit(false), Bit(true)))
        assertEquals(Bit(false), and.apply(Bit(true), Bit(false)))
        assertEquals(Bit(true), and.apply(Bit(true), Bit(true)))
    }

    // 4 value logic
    @Test
    fun quad() {
        val and = And()

        assertEquals(Bit(false, false), and.apply(Bit(false, true), Bit(false, false)))
        assertEquals(Bit(false, true), and.apply(Bit(false, true), Bit(false, true)))
        assertEquals(Bit(false, false), and.apply(Bit(false, true), Bit(true, false)))
        assertEquals(Bit(false, true), and.apply(Bit(false, true), Bit(true, true)))

        assertEquals(Bit(false, false), and.apply(Bit(true, false), Bit(false, false)))
        assertEquals(Bit(false, false), and.apply(Bit(true, false), Bit(false, true)))
        assertEquals(Bit(true, false), and.apply(Bit(true, false), Bit(true, false)))
        assertEquals(Bit(true, false), and.apply(Bit(true, false), Bit(true, true)))

        assertEquals(Bit(false, false), and.apply(Bit(false, false), Bit(false, false)))
        assertEquals(Bit(false, false), and.apply(Bit(false, false), Bit(false, true)))
        assertEquals(Bit(false, false), and.apply(Bit(false, false), Bit(true, false)))
        assertEquals(Bit(false, false), and.apply(Bit(false, false), Bit(true, true)))

        assertEquals(Bit(false, false), and.apply(Bit(true, true), Bit(false, false)))
        assertEquals(Bit(false, true), and.apply(Bit(true, true), Bit(false, true)))
        assertEquals(Bit(true, false), and.apply(Bit(true, true), Bit(true, false)))
        assertEquals(Bit(true, true), and.apply(Bit(true, true), Bit(true, true)))
    }

}