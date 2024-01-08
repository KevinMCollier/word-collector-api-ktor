package com.example.user

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
internal class UserTest {
    @Test
    fun `create user with required fields`() {
        val user = User("1", "John", "Doe", "john.doe@example.com")
        assertNotNull(user)
        assertEquals("John", user.firstName)
        assertEquals("Doe", user.lastName)
        assertEquals("john.doe@example.com", user.email)
    }
}