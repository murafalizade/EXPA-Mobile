package org.aiesec.main

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.aiesec.domain.entities.People
import org.aiesec.main.adapters.PeopleAdapter

class HomeFragment : Fragment() {

    private lateinit var adapter: PeopleAdapter
    private lateinit var recyclerView: RecyclerView
    private val mockPeople = MutableLiveData<List<People>>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.managerRecyclerView)
        adapter = PeopleAdapter()

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        listOf<People>(
            People(
                id = "1",
                firstName = "John",
                lastName = "Doe",
                profilePicture = "https://cdn-expa.aiesec.org/gis-img/missing_profile_n.svg",
                managers = listOf(
                    People(id = "2", firstName = "Jane", lastName = "Smith", profilePicture = "https://example.com/profile2.jpg", managers = emptyList())
                )
            ),
            People(
                id = "2",
                firstName = "Jane",
                lastName = "Smith",
                profilePicture = "https://cdn-expa.aiesec.org/gis-img/missing_profile_n.svg",
                managers = listOf(
                    People(id = "1", firstName = "John", lastName = "Doe", profilePicture = "https://example.com/profile1.jpg", managers = emptyList())
                )
            ),
        ).also { mockPeople.value = it }

        mockPeople.observe(viewLifecycleOwner) { people ->
            adapter.submitList(people)
        }
    }
}