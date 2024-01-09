package com.example.user

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
}