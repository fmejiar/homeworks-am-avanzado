package com.fmejiar.homework_01.interfaces

import com.fmejiar.homework_01.model.FruitEntity

interface OnFruitListener {

    fun selectedItemFruit(fruitEntity: FruitEntity)
    fun renderFirst(fruitEntity: FruitEntity?)

}