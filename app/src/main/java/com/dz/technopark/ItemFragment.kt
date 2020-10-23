package com.dz.technopark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ItemFragment : Fragment() {

    private lateinit var listener: SwitcherInterface

    private var columnCount = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (context is SwitcherInterface) {
            listener = context as SwitcherInterface
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        columnCount = resources.getInteger(R.integer.column)

        return inflater.inflate(R.layout.fragment_item_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.list)
        val b = view.findViewById<View>(R.id.btn_do_it)
        b.setOnClickListener {
            DataSource.add()
            recycler.adapter?.notifyItemInserted(DataSource.size())
        }

        with(recycler) {
            layoutManager = when {
                columnCount <= 1 -> LinearLayoutManager(context)
                else -> GridLayoutManager(context, columnCount)
            }
            adapter = MyItemRecyclerViewAdapter(DataSource.get(), listener)
        }

    }

}