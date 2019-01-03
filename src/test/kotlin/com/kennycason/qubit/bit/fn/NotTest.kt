package com.kennycason.qubit.bit.fn

import com.kennycason.qubit.bit.Bit
import junit.framework.Assert.assertFalse
import org.junit.Test
import kotlin.test.assertEquals


class NotTest {

    // 2 value logic
    @Test
    fun binary() {
        val not = Not()

        assertEquals(Bit(true), not.apply(Bit(false)))
        assertEquals(Bit(false), not.apply(Bit(true)))
    }

    // 4 value logic
    @Test
    fun quad() {
        val not = Not()

        assertEquals(Bit(true, true), not.apply(Bit(false, false)))
        assertEquals(Bit(true, false), not.apply(Bit(false, true)))
        assertEquals(Bit(false, true), not.apply(Bit(true, false)))
        assertEquals(Bit(false, false), not.apply(Bit(true, true)))
    }

}