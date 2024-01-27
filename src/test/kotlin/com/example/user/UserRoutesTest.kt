package com.example.user


import com.example.plugins.configureRouting
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class UserRoutesTest {

//    @Test
//    fun `test simplified get route`() = testApplication {
//        application {
//            configureRouting(InMemoryUserRepository())
//        }
//
//        val response = client.get("/user")
//
//        assertEquals(HttpStatusCode.OK, response.status)
//        assertEquals("Test response", response.bodyAsText())
//    }

    @Test
    fun `get all method returns all users`() = testApplication {
        InMemoryUserRepository.clear() // Implement this method to clear the repository state

        InMemoryUserRepository.add(User("1", "John", "Doe", "john@example.com"))

        // Debugging: Print the repository contents
        println("Repository contents before test request: ${InMemoryUserRepository.getAll()}")

        application {
            configureRouting(InMemoryUserRepository)
        }

        val response = client.get("/user")

        // Print the response for debugging
        val responseBody = response.bodyAsText()
        println("Response: $responseBody")

        assertEquals(HttpStatusCode.OK, response.status)
        assertTrue(responseBody.contains("John"), "Response body does not contain 'John': $responseBody")
    }


}