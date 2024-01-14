package com.example.user

class InMemoryUserRepository: UserRepository {
    private val repository = mutableListOf<User>()

    override fun add(user: User): Boolean {
        repository.add(user)
        return true
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