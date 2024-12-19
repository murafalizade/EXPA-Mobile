package org.aiesec.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import org.aiesec.domain.entities.People
import org.aiesec.domain.repositories.PeopleRepository

class HomeViewModel(private val repository: PeopleRepository) : ViewModel() {

    val people: LiveData<List<People>> = liveData {
        val data = repository.getPeople()
        emit(data)
    }
}
