package com.example.user

class MockUserRepository: UserRepository {
    private val userList = mutableListOf<User>()
    private val user = User("1", "John", "Doe", "john.doe@example.com")
    var addInvoked = false
    var addUserSuccess = true
    var updateInvoked = false
    var updateUserSuccess = true
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
    override fun update(user: User): Boolean {
        val index = userList.indexOfFirst { it.id == user.id }
        if (index != -1 && updateUserSuccess) {
            userList[index] = user
            updateInvoked = true
            return true
        }
        return false
    }

    override fun delete(userId: String): Boolean {
        return userList.removeIf { it.id == userId }
    }
}

