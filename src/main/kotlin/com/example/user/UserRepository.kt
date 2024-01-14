package com.example.user

interface UserRepository {
    fun add(user: User): Boolean
}
