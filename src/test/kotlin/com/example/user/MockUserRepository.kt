package com.example.user

class MockUserRepository: UserRepository {
    var addInvoked = false
    var addUserSuccess = true
    override fun add(user: User): Boolean {
        if (addUserSuccess) {
            addInvoked = true
            return true
        } else {
            return false
        }
    }
}

