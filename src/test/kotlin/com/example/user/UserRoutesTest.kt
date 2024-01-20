package com.example

import com.example.user.MockUserRepository
import com.example.user.User
import com.example.plugins.configureRouting
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class UserRoutesTest {
    @Test
    fun `get all users returns all users`() = testApplication {
        val mockRepository = MockUserRepository().apply {
            add(User("1", "John", "Doe", "john.doe@example.com"))
            add(User("2", "Jane", "Doe", "jane.doe@example.com"))
        }
        application {
            configureRouting(mockRepository)
        }

        client.get("/users").apply {
            assertEquals(HttpStatusCode.OK, status)
            val users = bodyAsText()
            assertTrue(users.contains("John") && users.contains("Jane"))
        }
    }
}
