package com.fmejiar.homework_01.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fmejiar.homework_01.R
import com.fmejiar.homework_01.adapters.PersonAdapter
import com.fmejiar.homework_01.interfaces.OnPersonListener
import com.fmejiar.homework_01.model.PersonEntity
import kotlinx.android.synthetic.main.fragment_persons.*

class PersonsFragment : Fragment() {

    private var listener: OnPersonListener? = null
    private var persons = mutableListOf<PersonEntity>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_persons, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnPersonListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnContactListener")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setData()

        lstPersons.adapter = PersonAdapter(persons)

        lstPersons.setOnItemClickListener { _, _, i, _ ->
            listener?.let {
                it.selectedItemPerson(persons[i])
            }
        }

        listener?.renderFirst(first())

    }

    private fun first(): PersonEntity? = persons?.first()

    private fun setData() {

        val person1 = PersonEntity(
            1,
            "Juan Pérez",
            R.drawable.foto_persona_1,
            "992753167",
            "prueba1@gmail.com",
            "www.ebay.com"
        )

        val person2 = PersonEntity(
            2,
            "Rosa Salas",
            R.drawable.foto_persona_2,
            "995581274",
            "prueba2@gmail.com",
            "www.amazon.com"
        )

        val person3 = PersonEntity(
            3,
            "Luis Muro",
            R.drawable.foto_persona_3,
            "992341453",
            "prueba3@gmail.com",
            "www.ripley.com"
        )

        persons.add(person1)
        persons.add(person2)
        persons.add(person3)

    }

}