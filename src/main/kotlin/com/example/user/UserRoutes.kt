// UserRoutes.kt
package com.example.routes

import com.example.user.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.request.*

fun Route.userRouting(userRepository: UserRepository) {
    route("/user") {
        get {
//            call.respondText("Test response")
            val users = userRepository.getAll()
            println("Retrieved users: $users") // Debug print
            if (users.isNotEmpty()) {
                call.respond(users)
            } else {
                call.respondText("No users found", status = HttpStatusCode.OK)
            }
        }
        get("{id}") {
            val id = call.parameters["id"] ?: return@get call.respond(HttpStatusCode.BadRequest)
            val user = userRepository.get(id)
            if (user != null) {
                call.respond(user)
            } else {
                call.respondText("No user found with id $id", status = HttpStatusCode.NotFound)
            }
        }
        post {
            val user = call.receive<User>()
            userRepository.add(user)
            call.respondText("User added successfully", status = HttpStatusCode.Created)
        }
        delete("{id}") {
            val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
            if (userRepository.delete(id)) {
                call.respondText("User deleted successfully", status = HttpStatusCode.OK)
            } else {
                call.respondText("No user found with id $id", status = HttpStatusCode.NotFound)
            }
        }
    }
}
