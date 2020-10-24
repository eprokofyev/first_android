package com.dz.technopark

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), SwitcherInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val transaction = supportFragmentManager.beginTransaction()
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