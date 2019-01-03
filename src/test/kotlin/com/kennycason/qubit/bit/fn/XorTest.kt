package com.kennycason.qubit.bit.fn

import com.kennycason.qubit.bit.Bit
import junit.framework.Assert.assertFalse
import org.junit.Test
import kotlin.test.assertEquals


class XorTest {

    // 2 value logic
    @Test
    fun binary() {
        val xor = Xor()

        assertEquals(Bit(false), xor.apply(Bit(false), Bit(false)))
        assertEquals(Bit(true), xor.apply(Bit(false), Bit(true)))
        assertEquals(Bit(true), xor.apply(Bit(true), Bit(false)))
        assertEquals(Bit(false), xor.apply(Bit(true), Bit(true)))
    }

    // 4 value logic
    @Test
    fun quad() {
        val xor = Xor()

        assertEquals(Bit(false, true), xor.apply(Bit(false, true), Bit(false, false)))
        assertEquals(Bit(false, false), xor.apply(Bit(false, true), Bit(false, true)))
        assertEquals(Bit(true, true), xor.apply(Bit(false, true), Bit(true, false)))
        assertEquals(Bit(true, false), xor.apply(Bit(false, true), Bit(true, true)))

        assertEquals(Bit(true, false), xor.apply(Bit(true, false), Bit(false, false)))
        assertEquals(Bit(true, true), xor.apply(Bit(true, false), Bit(false, true)))
        assertEquals(Bit(false, false), xor.apply(Bit(true, false), Bit(true, false)))
        assertEquals(Bit(false, true), xor.apply(Bit(true, false), Bit(true, true)))

        assertEquals(Bit(false, false), xor.apply(Bit(false, false), Bit(false, false)))
        assertEquals(Bit(false, true), xor.apply(Bit(false, false), Bit(false, true)))
        assertEquals(Bit(true, false), xor.apply(Bit(false, false), Bit(true, false)))
        assertEquals(Bit(true, true), xor.apply(Bit(false, false), Bit(true, true)))

        assertEquals(Bit(true, true), xor.apply(Bit(true, true), Bit(false, false)))
        assertEquals(Bit(true, false), xor.apply(Bit(true, true), Bit(false, true)))
        assertEquals(Bit(false, true), xor.apply(Bit(true, true), Bit(true, false)))
        assertEquals(Bit(false, false), xor.apply(Bit(true, true), Bit(true, true)))
    }

}