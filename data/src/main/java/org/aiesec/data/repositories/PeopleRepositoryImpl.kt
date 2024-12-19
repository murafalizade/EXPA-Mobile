package org.aiesec.data.repositories

import org.aiesec.domain.entities.People
import org.aiesec.domain.repositories.PeopleRepository

class PeopleRepositoryImpl:PeopleRepository {
    override fun getPeople(): List<People> {
        return mockPeople;
    }

    override fun getPeopleById(id:String): People {
       return mockPeople.first{it.id == id};
    }

    companion object{
        val mockPeople = listOf(
            People(
                id = "1",
                firstName = "John",
                lastName = "Doe",
                profilePicture = "https://example.com/profile1.jpg",
                managers = listOf(
                    People(id = "2", firstName = "Jane", lastName = "Smith", profilePicture = "https://example.com/profile2.jpg", managers = emptyList())
                )
            ),
            People(
                id = "2",
                firstName = "Jane",
                lastName = "Smith",
                profilePicture = "https://example.com/profile2.jpg",
                managers = listOf(
                    People(id = "1", firstName = "John", lastName = "Doe", profilePicture = "https://example.com/profile1.jpg", managers = emptyList())
                )
            ),
        )
    }
}
