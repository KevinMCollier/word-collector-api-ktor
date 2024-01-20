package com.example.plugins

import com.example.user.UserRepository
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting(userRepository: UserRepository) {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }
}
