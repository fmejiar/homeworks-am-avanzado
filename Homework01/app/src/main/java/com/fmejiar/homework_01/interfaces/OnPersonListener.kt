package com.fmejiar.homework_01.interfaces

import com.fmejiar.homework_01.model.PersonEntity

interface OnPersonListener {

    fun selectedItemPerson(personEntity: PersonEntity)
    fun renderFirst(personEntity: PersonEntity?)

}