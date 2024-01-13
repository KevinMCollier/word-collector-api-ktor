package com.example.user

class InMemoryUserRepository {
    private val repository = mutableListOf<User>()

    fun add(user: User) {
        repository.add(user)
    }

    fun contains(user: User): Boolean {
        return repository.contains(user)
    }

    fun get(userId: String): User? {
        return repository.find { it.id == userId }
    }

    fun getAll(): List<User> {
        return repository.toList()
    }
}