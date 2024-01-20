package com.example.user

import kotlinx.serialization.json.Json

fun deserializeUsers(json: String): List<User> {
    return Json.decodeFromString(json)
}