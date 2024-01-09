package com.example.user

class User(val id: String, val firstName: String, val lastName: String, val email: String) {
    init {
        require(email.contains("@") && email.contains(".")) {"Invalid email format"}
    }
}
