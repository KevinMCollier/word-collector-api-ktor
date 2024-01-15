package com.example.user

import org.junit.jupiter.api.Test
import kotlin.test.assertTrue
import kotlin.test.assertFalse

internal class UserRepositoryTest {
    private lateinit var repository: MockUserRepository
    private lateinit var testUser: User
    @Test
    fun `add method should return true when a new user is added successfully`() {
        repository = MockUserRepository()
        repository.addUserSuccess = true
        testUser = User("1", "John", "Doe", "john.doe@example.com")

        val result = repository.add(testUser)
        assertTrue(result)
        assertTrue(repository.addInvoked)
    }

    @Test
    fun `add method should return false when adding a new user fails`() {
        repository = MockUserRepository()
        repository.addUserSuccess = false
        testUser = User("1", "John", "Doe", "john.doe@example.com")

        val result = repository.add(testUser)
        assertFalse(result)
        assertFalse(repository.addInvoked)
    }
}