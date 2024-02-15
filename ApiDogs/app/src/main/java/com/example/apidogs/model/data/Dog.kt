package com.example.apidogs.model.data

import java.io.Serializable

data class Dog(
    val name: String,
    var imageUrl: String,
    var description: String? = ""
):Serializable
