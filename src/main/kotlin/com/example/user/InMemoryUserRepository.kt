package com.example.user

class InMemoryUserRepository: UserRepository {
    private val userList = mutableListOf<User>()

    override fun add(user: User): Boolean {
        userList.add(user)
        return true
    }

    fun contains(user: User): Boolean {
        return userList.contains(user)
    }

    fun get(userId: String): User? {
        return userList.find { it.id == userId }
    }

    override fun getAll(): List<User> {
        return userList.toList()
    }
}