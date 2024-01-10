package com.example.user

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

internal class UserTest {
    @Test
    fun `create user with required fields`() {
        val user = User("1", "John", "Doe", "john.doe@example.com")
        assertNotNull(user)
        assertEquals("John", user.firstName)
        assertEquals("Doe", user.lastName)
        assertEquals("john.doe@example.com", user.email)
    }
    @Test
    fun `user email format is valid`() {
        val user = User("1", "John", "Doe", "john.doe@example.com")
        assertTrue(user.email.contains("@") && user.email.contains("."))
    }
    @Test
    fun `user email format is invalid`() {
        assertThrows<IllegalArgumentException> {
            User("1", "John", "Doe", "fakeemail")
        }
    }
    @Test
    fun `user data is serialized to JSON format`() {
        val user = User("1", "John", "Doe", "john.doe@example.com")
        val json = Json.encodeToString(user)

        assertTrue(json.startsWith("{") && json.endsWith("}"))

        assertTrue(json.contains("\"id\":\"1"))
        assertTrue(json.contains("\"firstName\":\"John\""))
        assertTrue(json.contains("\"lastName\":\"Doe\""))
        assertTrue(json.contains("\"email\":\"john.doe@example.com\""))
    }
}