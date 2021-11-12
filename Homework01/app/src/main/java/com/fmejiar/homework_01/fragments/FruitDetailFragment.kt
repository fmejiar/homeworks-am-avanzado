package com.fmejiar.homework_01.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fmejiar.homework_01.R
import com.fmejiar.homework_01.interfaces.OnFruitListener
import com.fmejiar.homework_01.model.FruitEntity
import kotlinx.android.synthetic.main.fragment_fruit_detail.*

class FruitDetailFragment : Fragment() {

    private var listener: OnFruitListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fruit_detail, container, false)
    }

    fun renderFruit(fruitEntity: FruitEntity) {
        val name = fruitEntity.name
        val price = fruitEntity.price
        val description = fruitEntity.description

        iviFruitPhoto.setImageResource(fruitEntity.photo)
        tvName.text = name
        tvPrice.text = price
        tvDescription.text = description
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFruitListener) {
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