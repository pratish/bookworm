package com.code.range.bookworm

import com.code.range.bookworm.data.network.ApiClientFactory
import com.code.range.bookworm.data.network.GoogleBookApi
import com.code.range.bookworm.data.network.dto.RemoteBookList
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import retrofit2.Response
import retrofit2.awaitResponse
import kotlin.time.Duration
import kotlin.time.measureTimedValue

class ApiClientTest {

    @Test
    fun `make sure that only single instance of apiclient exists`() {
        val apiClient1 = System.identityHashCode(ApiClientFactory.instance)
        val apiClient2 = System.identityHashCode(ApiClientFactory.instance)
        assertEquals(apiClient1, apiClient2)
    }

    @Test
    fun `test time to call the api once`() {
        val apiClientToTest = ApiClientFactory.instance.create(GoogleBookApi::class.java)
        val totalTime = measureTimedValue {
            apiClientToTest.getBooks("quilting").execute()
        }
        println(totalTime)
        assertNotNull(totalTime)
    }

    @Test
    fun `make sure that 2 calls can be made with the apiclient`() = runTest {
        lateinit var response1: Response<RemoteBookList>
        lateinit var response2: Response<RemoteBookList>
        val apiClient1 = ApiClientFactory.instance
        val googleApi1 = apiClient1.create(GoogleBookApi::class.java)
        val googleApi2 = apiClient1.create(GoogleBookApi::class.java)
        assertNotEquals(googleApi1, googleApi2)
        val totalTime = measureTimedValue {
            async {
                launch {
                    println("calling 1")
                    response1 = googleApi1.getBooks("quilting").awaitResponse()
                    println("finished calling 1")
                }
                launch {
                    println("calling 2")
                    response2 = googleApi2.getBooks("quilting").awaitResponse()
                    println("finished calling 2")
                }
            }.await()
        }
        println("totaltime: $totalTime")
        assertEquals(response1.body()?.items?.size, response2.body()?.items?.size)
    }

    @Test
    fun `make sure x calls can be made with apiclient simultaneously`() = runTest(timeout =
                                                                                  Duration.INFINITE) {
        val apiClientToTest = ApiClientFactory.instance
        val responses: MutableSet<Int?> = mutableSetOf()
        val numberOfInstances = 20
        val requests = IntRange(start = 0, endInclusive = numberOfInstances).map { _ ->
            apiClientToTest.create(GoogleBookApi::class.java)
        }
        val totalTime = measureTimedValue {
            async {
                requests.forEachIndexed { index, it ->
                    launch {
                        println("making call... $index")
                        responses.add(
                            it.getBooks("quilting").awaitResponse().body()?.items?.size
                        )
                        println("finished making call... $index")
                    }
                }
            }.await()
        }
        println("totalTime = $totalTime")
        assertTrue(responses.size == 1)
    }
}