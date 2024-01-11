package com.example.user

class UserStorage {
    private val storage = mutableListOf<User>()

    fun add(user: User) {
        storage.add(user)
    }

    fun contains(user: User): Boolean {
        return storage.contains(user)
    }
}