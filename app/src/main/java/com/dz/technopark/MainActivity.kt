package com.dz.technopark

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), SwitcherInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val transaction = supportFragmentManager.beginTransaction()
        val top = supportFragmentManager.findFragmentById(R.id.items)
        top?.arguments = savedInstanceState
        if (savedInstanceState == null) {
            transaction.add(R.id.items, ItemFragment.newInstance(resources.getInteger(R.integer.max)))
            transaction.commitAllowingStateLoss()
        }
    }


    override fun switch(number: Int, color: Int) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.items, NumberFragment.newInstance(number, color))
            addToBackStack(null)
            commitAllowingStateLoss()
        }
    }

}