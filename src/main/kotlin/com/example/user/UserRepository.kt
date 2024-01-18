package com.example.user

interface UserRepository {
    fun add(user: User): Boolean
    fun getAll(): List<User>
    fun get(userId: String): User?
    fun update(user: User): Boolean
}
