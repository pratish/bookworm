package com.code.range.bookworm

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun `test data class`() {
        val u1 = User("test1", "1234")
        val u2 = User("test1", "1235")

        assertTrue(u1 == u2)
        println(System.identityHashCode(u1))
        println(System.identityHashCode(u2))
        assertTrue(u1.name === u2.name)
    }
}

data class User(val name: String, val phone: String)
class UserClass(val name: String, val phone: String)