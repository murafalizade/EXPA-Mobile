package org.aiesec.domain.entities

data class People(val id:String, val firstName: String, val lastName: String, val profilePicture: String, val managers: List<People>)
