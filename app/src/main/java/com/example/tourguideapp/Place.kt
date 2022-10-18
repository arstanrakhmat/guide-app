package com.example.tourguideapp

data class Place(
    val image: Int,
    val title: String,
    val smallTitle: String,
    var visibility: Boolean = false,
    val details: String,
    val location: String
)
{
    var phoneNumber = ""

    constructor(image: Int,
    title: String,
    smallTitle: String,
    visibility: Boolean = false,
    details: String,
    location: String,
    phoneNumber: String) : this(image, title, smallTitle, visibility, details, location) {
        this.phoneNumber = phoneNumber
    }
}
