package com.example.softwarescrolling

import android.media.Image

data class PersonModel(
    val image: Int,
    val name: String,
    val lastName: String,
    val employee: Employee,
    val salary: Int
) {
}