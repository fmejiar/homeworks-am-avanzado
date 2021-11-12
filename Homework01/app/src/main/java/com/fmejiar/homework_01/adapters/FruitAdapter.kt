package com.fmejiar.homework_01.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.fmejiar.homework_01.R
import com.fmejiar.homework_01.model.FruitEntity

class FruitAdapter(private val fruits: List<FruitEntity>) : BaseAdapter() {

    override fun getCount(): Int = fruits.size

    override fun getItem(position: Int) = fruits[position]

    override fun getItemId(p0: Int): Long = 0

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val inflater = LayoutInflater.from(parent?.context)
        val container = inflater.inflate(R.layout.row_fruit, null)
        val imgFruit = container.findViewById<ImageView>(R.id.iviFruit)
        val tviName = container.findViewById<TextView>(R.id.tviName)
        val tviPrice = container.findViewById<TextView>(R.id.tviPrice)
        val fruitEntity = fruits[position]

        tviName.text = fruitEntity.name
        imgFruit.setImageResource(fruitEntity.photo)
        tviPrice.text = fruitEntity.price

        return container
    }

}