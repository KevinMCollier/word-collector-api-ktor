package com.example.plugins

import com.example.routes.userRouting
import com.example.user.InMemoryUserRepository
import com.example.user.UserRepository
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting(userRepository: UserRepository = InMemoryUserRepository) {
    routing {
        userRouting(userRepository)
    }
}
