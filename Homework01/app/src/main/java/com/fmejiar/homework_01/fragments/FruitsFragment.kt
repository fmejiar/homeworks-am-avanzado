package com.fmejiar.homework_01.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fmejiar.homework_01.R
import com.fmejiar.homework_01.adapters.FruitAdapter
import com.fmejiar.homework_01.interfaces.OnFruitListener
import com.fmejiar.homework_01.model.FruitEntity
import kotlinx.android.synthetic.main.fragment_fruits.*

class FruitsFragment : Fragment() {

    private var listener: OnFruitListener? = null
    private var fruits = mutableListOf<FruitEntity>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fruits, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFruitListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnContactListener")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setData()

        lstFruits.adapter = FruitAdapter(fruits)

        lstFruits.setOnItemClickListener { _, _, i, _ ->
            listener?.let {
                it.selectedItemFruit(fruits[i])
            }
        }

        listener?.renderFirst(first())

    }

    private fun setData() {
        val fruit1 = FruitEntity(
            1,
            "Apple",
            R.drawable.apple_fruit_icon,
            "La manzana es el fruto comestible de la especie Malus domestica, el manzano común",
            "S/. 2.00"
        )

        val fruit2 = FruitEntity(
            2,
            "Lemon",
            R.drawable.lemon_fruit_icon,
            "El limón es un auténtico tesoro nutricional y muy beneficioso para nuestra salud",
            "S/. 0.50"
        )

        val fruit3 = FruitEntity(
            3,
            "Grape",
            R.drawable.grape_fruit_icon,
            "La uva es un fruta que crece en racimos apretados. Su pulpa es blanca o púrpura y de sabor dulce",
            "S/. 3.00"
        )

        fruits.add(fruit1)
        fruits.add(fruit2)
        fruits.add(fruit3)
    }

    private fun first(): FruitEntity? = fruits?.first()

}