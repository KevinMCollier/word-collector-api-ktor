package com.example.user

class MockUserRepository: UserRepository {
    private val userList = mutableListOf<User>()
    private val user = User("1", "John", "Doe", "john.doe@example.com")
    var addInvoked = false
    var addUserSuccess = true
    override fun add(user: User): Boolean {
        if (addUserSuccess) {
            userList.add(user)
            addInvoked = true
            return true
        } else {
            return false
        }
    }
    override fun getAll(): List<User> {
        return userList
    }

    override fun get(userId: String): User? {
        return userList.find { it.id == userId }
    }
}

