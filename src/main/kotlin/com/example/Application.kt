package com.example

import com.example.plugins.*
import com.example.user.InMemoryUserRepository
import com.example.user.UserRepository
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {

    val inMemoryUserRepository = InMemoryUserRepository
    configureSerialization()
    configureRouting(inMemoryUserRepository)
}

