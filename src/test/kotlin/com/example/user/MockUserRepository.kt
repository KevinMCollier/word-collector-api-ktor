package com.example.user

class MockUserRepository: UserRepository {
    var addInvoked = false
    override fun add(user: User): Boolean {
        addInvoked = true
        return true
    }

}
