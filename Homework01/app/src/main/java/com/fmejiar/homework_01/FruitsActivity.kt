package com.fmejiar.homework_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import com.fmejiar.homework_01.fragments.FruitDetailFragment
import com.fmejiar.homework_01.fragments.FruitsFragment
import com.fmejiar.homework_01.interfaces.OnFruitListener
import com.fmejiar.homework_01.model.FruitEntity

class FruitsActivity : AppCompatActivity(), OnFruitListener {

    private lateinit var fruitsFragment: FruitsFragment
    private lateinit var fruitDetailFragment: FruitDetailFragment
    private lateinit var fragmentManager: FragmentManager

    override fun selectedItemFruit(fruitEntity: FruitEntity) {
        Log.v("CONSOLE", "selectedItemFruit")
        fruitDetailFragment.renderFruit(fruitEntity)
    }

    override fun renderFirst(fruitEntity: FruitEntity?) {
        fruitEntity?.let {
            selectedItemFruit(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruits)

        fragmentManager = supportFragmentManager
        fruitsFragment = fragmentManager.findFragmentById(R.id.fragFruits) as FruitsFragment
        fruitDetailFragment = fragmentManager.findFragmentById(R.id.fragFruitDetail) as FruitDetailFragment
    }
}