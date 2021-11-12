package com.fmejiar.homework_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import com.fmejiar.homework_01.fragments.FruitDetailFragment
import com.fmejiar.homework_01.fragments.FruitsFragment
import com.fmejiar.homework_01.fragments.PersonDetailFragment
import com.fmejiar.homework_01.fragments.PersonsFragment
import com.fmejiar.homework_01.interfaces.OnPersonListener
import com.fmejiar.homework_01.model.PersonEntity

class PersonsActivity : AppCompatActivity(), OnPersonListener {

    private lateinit var personsFragment: PersonsFragment
    private lateinit var personDetailFragment: PersonDetailFragment
    private lateinit var fragmentManager: FragmentManager

    override fun selectedItemPerson(personEntity: PersonEntity) {
        Log.v("CONSOLE", "selectedItemPerson")
        personDetailFragment.renderPerson(personEntity)
    }

    override fun renderFirst(personEntity: PersonEntity?) {
        personEntity?.let {
            selectedItemPerson(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persons)

        fragmentManager = supportFragmentManager
        personsFragment = fragmentManager.findFragmentById(R.id.fragPersons) as PersonsFragment
        personDetailFragment = fragmentManager.findFragmentById(R.id.fragPersonDetail) as PersonDetailFragment
    }
}