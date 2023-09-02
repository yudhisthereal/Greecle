package com.ggroup.greecle.models

data class User(
    val userName: String?,
    val email: String,
    val name: String,
    val phone: String,
    val location: GreecleLocation
)
