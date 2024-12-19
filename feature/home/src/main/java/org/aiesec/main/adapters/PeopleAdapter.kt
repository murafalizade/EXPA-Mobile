package org.aiesec.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil3.load
import org.aiesec.domain.entities.People
import org.aiesec.main.R

class PeopleAdapter : RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>() {

    private var peopleList = listOf<People>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.person_item, parent, false)
        return PeopleViewHolder(view)
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val person = peopleList[position]
        holder.bind(person)
    }

    override fun getItemCount(): Int = peopleList.size

    fun submitList(people: List<People>) {
        peopleList = people
        notifyDataSetChanged()
    }

    class PeopleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val profileImageView: ImageView = itemView.findViewById(R.id.profileImage3)
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)
        private val managerProfilesLayout: LinearLayout =
            itemView.findViewById(R.id.managerProfilesLayout)

        fun bind(person: People) {
            // Bind person data to the UI
            nameTextView.text = "${person.firstName} ${person.lastName}"
            dateTextView.text = "19 Dec, 2024" // Example date
            println(person.profilePicture)
            profileImageView.load(person.profilePicture)
        }
    }
}
