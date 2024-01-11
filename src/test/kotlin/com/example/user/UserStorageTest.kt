package com.example.user

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
internal class UserStorageTest {
    private val userStorage = UserStorage()
    @Test
    fun `add user to storage`() {
        val user = User("1", "John", "Doe", "john.doe@example.com")
        userStorage.add(user)
        assertTrue(userStorage.contains(user))
    }
}