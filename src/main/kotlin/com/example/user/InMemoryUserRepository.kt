package com.example.user

object InMemoryUserRepository: UserRepository {
    private val userList = mutableListOf<User>()

    override fun add(user: User): Boolean {
        userList.add(user)
        return true
    }

    fun contains(user: User): Boolean {
        return userList.contains(user)
    }

    override fun get(userId: String): User? {
        return userList.find { it.id == userId }
    }

    override fun getAll(): List<User> {
        return userList.toList()
    }

    override fun update(user: User): Boolean {
        val index = userList.indexOfFirst { it.id == user.id }
        if (index != -1) {
            userList[index] = user
            return true
        }
        return false
    }

    override fun delete(userId: String): Boolean {
        return userList.removeIf { it.id == userId }
    }

    fun clear() {
        userList.clear()
    }
}