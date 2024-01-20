package com.example.user

import com.example.plugins.configureRouting
import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class UserRoutesTest {
    @Test
    fun `GET all users should return empty list`() = testApplication {
        val mockUserRepository = MockUserRepository()
        application {
            configureRouting(mockUserRepository)
        }

        val response = client.get("/user")

        assertEquals(HttpStatusCode.OK, response.status)
        assertTrue(response.bodyAsText().isEmpty())
    }
}