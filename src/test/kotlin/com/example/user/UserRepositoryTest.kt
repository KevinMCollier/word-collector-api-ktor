package com.example.user

import org.junit.jupiter.api.Test
import kotlin.test.assertTrue
import kotlin.test.assertFalse
import kotlin.test.assertEquals

internal class UserRepositoryTest {
    @Test
    fun `add method should return true when a new user is added successfully`() {
        val repository = InMemoryUserRepository()
        val testUser = User("1", "John", "Doe", "john.doe@example.com")

        val result = repository.add(testUser)
        assertTrue(result)
        assertTrue(repository.contains(testUser))
    }
    @Test
    fun `read-all method should return all user objects`() {
        //arrange
        val repository = InMemoryUserRepository()
        val testUser1 = User("1", "John", "Doe", "john.doe@example.com")
        val testUser2 = User("2", "Billy", "Bob", "billy.bob@example.com")
        val testUser3 = User("3", "Suzy", "May", "suzy.may@example.com")
        repository.add(testUser1)
        repository.add(testUser2)
        repository.add(testUser3)

        //act
        val result = repository.getAll()

        //assert
        assertEquals(listOf(testUser1, testUser2, testUser3), result)
    }
    @Test
    fun `read method should return one user object`() {
        val repository = InMemoryUserRepository()
        val testUser1 = User("1", "John", "Doe", "john.doe@example.com")
        val testUser2 = User("2", "Billy", "Bob", "billy.bob@example.com")
        val testUser3 = User("3", "Suzy", "May", "suzy.may@example.com")
        repository.add(testUser1)
        repository.add(testUser2)
        repository.add(testUser3)

        val result = repository.get(testUser1.id)

        assertEquals(testUser1, result)
    }

    @Test
    fun `update method should return true when a user is successfully updated`() {
        val repository = InMemoryUserRepository()
        val testUser = User("1", "John", "Doe", "john.doe@example.com")
        repository.add(testUser)

        val updatedUser = testUser.copy(email = "john.updated@example.com")
        val result = repository.update(updatedUser)

        assertTrue(result)
    }

    @Test
    fun `updated user data should be reflected in the repository`() {
        val repository = InMemoryUserRepository()
        val testUser = User("1", "John", "Doe", "john.doe@example.com")
        repository.add(testUser)

        val updatedUser = testUser.copy(email = "john.updated@example.com")
        repository.update(updatedUser)
        val retrievedUser = repository.get(testUser.id)

        assertEquals(updatedUser, retrievedUser)
    }










//    @Test
//    fun `update method should return false when updating a non-existent user`() {
//        val repository = MockUserRepository()
//        val testUser1 = User("1", "John", "Doe", "john.doe@example.com")
//        repository.add(testUser1)
//
//        val userToUpdate = repository.get(testUser1.id)
//        val updatedUser = userToUpdate.update("1", "Johnny", "Boy", "johnny.boy@example.com")
//        val result = repository.get(updatedUser.id)
//
//        assertEquals(updatedUser.id, result)

//    }
//
//    @Test
//    fun `update method should update the name of the user`() {
//
//    }
}