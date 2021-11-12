package com.fmejiar.homework_01.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.fmejiar.homework_01.R
import com.fmejiar.homework_01.model.PersonEntity

class PersonAdapter(private val persons: List<PersonEntity>) : BaseAdapter() {

    override fun getCount(): Int = persons.size

    override fun getItem(position: Int) = persons[position]

    override fun getItemId(p0: Int): Long = 0

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val inflater = LayoutInflater.from(parent?.context)
        val container = inflater.inflate(R.layout.row_person, null)

        val imgPerson = container.findViewById<ImageView>(R.id.iviPerson)
        val tviName = container.findViewById<TextView>(R.id.tviPersonName)

        val personEntity = persons[position]

        tviName.text = personEntity.name
        imgPerson.setImageResource(personEntity.photo)

        return container
    }

}