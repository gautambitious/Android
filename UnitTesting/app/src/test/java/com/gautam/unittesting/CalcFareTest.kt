package com.gautam.unittesting

import org.junit.Assert.assertEquals
import org.junit.Test

class CalcFareTest {
    @Test
    fun  caclFare_for_0km_0min(){
        assertEquals(60f,CalciFareUtil.calculateFare(0f,0))
    }


}