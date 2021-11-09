package dev.gressier.food2fork

import org.junit.Assert.assertTrue
import org.junit.Test

class AndroidGreetingTest {

    @Test fun Check_that_Android_is_mentioned() {
        assertTrue(Greeting().greeting().contains("Android"))
    }
}