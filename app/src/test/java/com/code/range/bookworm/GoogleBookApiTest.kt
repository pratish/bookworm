package com.code.range.bookworm

import com.code.range.bookworm.data.network.ApiClientFactory
import com.code.range.bookworm.data.network.GoogleBookApi
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class GoogleBookApiTest {

//    private val objectToTest = ApiClientFactory.instance.create(MockGoogleBooksApi::class.java)

    private val objectToTest = MockGoogleBooksApi()
    @Test
    fun `make sure object to test is present`() {
        assertNotNull(objectToTest)
    }

    @Test
    fun `get list of books from cloud`() {
        assertNotNull(objectToTest.getBooks("quilting").execute().body())
        val objectsFound = objectToTest.getBooks("quilting").execute().body()?.items
        assertEquals("Sample data should have 4 items", 4, objectsFound?.size)
    }
}