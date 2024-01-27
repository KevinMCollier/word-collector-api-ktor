package com.example.user

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class InMemoryUserRepositoryTest {
    private val inMemoryUserRepository = InMemoryUserRepository
    @Test
    fun `add user to repository`() {
        val user = User("1", "John", "Doe", "john.doe@example.com")
        inMemoryUserRepository.add(user)
        assertTrue(inMemoryUserRepository.contains(user))
    }
    @Test
    fun `retrieve a specific user by ID`() {
        val user1 = User("1", "John", "Doe", "john.doe@example.com")
        inMemoryUserRepository.add(user1)

        val retrievedUser = inMemoryUserRepository.get("1")
        assertEquals(user1, retrievedUser)
    }
    @Test
    fun `retrieve all users`() {
        val user1 = User("1", "John", "Doe", "john.doe@example.com")
        val user2 = User("2", "Mary", "Poppins", "mary.poppins@example.com")
        inMemoryUserRepository.add(user1)
        inMemoryUserRepository.add(user2)

        val users = inMemoryUserRepository.getAll()
        assertTrue(users.containsAll(listOf(user1, user2)))
    }
}