package com.example.user

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.userRoutes(userRepository: UserRepository) {
    route("/user") {
        get {
            val usersList = userRepository.getAll()
            call.respond(usersList)
        }
    }
}