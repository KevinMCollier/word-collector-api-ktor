package com.example.user

import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

internal class UserRepositoryTest {
    private lateinit var repository: MockUserRepository
    private lateinit var testUser: User
    @Test
    fun `add method should return true when a new user is added successfully`() {
        repository = MockUserRepository()
        testUser = User("1", "John", "Doe", "john.doe@example.com")

        val result = repository.add(testUser)
        assertTrue(result)
        assertTrue(repository.addInvoked)
    }
}