package org.aiesec.domain.repositories

import org.aiesec.domain.entities.People

interface PeopleRepository {
    fun getPeople(): List<People>
    fun getPeopleById(id:String): People
}