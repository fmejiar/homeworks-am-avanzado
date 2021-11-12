package com.fmejiar.homework_01.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fmejiar.homework_01.R
import com.fmejiar.homework_01.interfaces.OnPersonListener
import com.fmejiar.homework_01.model.PersonEntity
import kotlinx.android.synthetic.main.fragment_person_detail.*

class PersonDetailFragment : Fragment() {

    private var listener: OnPersonListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_person_detail, container, false)
    }

    fun renderPerson(personEntity: PersonEntity) {
        val name = personEntity.name
        val phone = personEntity.phone
        val email = personEntity.email
        val website = personEntity.website

        iviPersonPhoto.setImageResource(personEntity.photo)
        tvName.text = name
        tvPhone.text = phone
        tvEmail.text = email
        tvWebsite.text = website
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnPersonListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnContactListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

}