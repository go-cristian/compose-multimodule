package com.baubap.common.repositories

data class User(
    val id: String,
    val name: String,
    val email: String,
    val username: String
) {
    val initials: String
        get() = name.split(" ").map { it.first() }.joinToString("")

    companion object {
        val Example = User(
            id = "123456789",
            name = "John Doe",
            email = "john.doe@example.com",
            username = "johndoe"
        )
    }
}