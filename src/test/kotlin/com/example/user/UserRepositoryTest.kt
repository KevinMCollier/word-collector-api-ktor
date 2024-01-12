package com.example.user

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class UserRepositoryTest {
    private val userRepository = UserRepository()
    @Test
    fun `add user to repository`() {
        val user = User("1", "John", "Doe", "john.doe@example.com")
        userRepository.add(user)
        assertTrue(userRepository.contains(user))
    }
    @Test
    fun `retrieve a specific user by ID`() {
        val user1 = User("1", "John", "Doe", "john.doe@example.com")
        userRepository.add(user1)

        val retrievedUser = userRepository.get("1")
        assertEquals(user1, retrievedUser)
    }
    @Test
    fun `retrieve all users`() {
        val user1 = User("1", "John", "Doe", "john.doe@example.com")
        val user2 = User("2", "Mary", "Poppins", "mary.poppins@example.com")
        userRepository.add(user1)
        userRepository.add(user2)

        val users = userRepository.getAll()
        assertTrue(users.containsAll(listOf(user1, user2)))
    }
}