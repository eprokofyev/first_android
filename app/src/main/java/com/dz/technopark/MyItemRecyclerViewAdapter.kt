package com.dz.technopark

import android.graphics.Color.BLUE
import android.graphics.Color.RED
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class MyItemRecyclerViewAdapter(
    private val values: MutableList<Int>,
    private val context: SwitcherInterface
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.idView.text = values[position].toString()
        holder.idView.setTextColor(
            if (values[position].rem(2)  == 0) {
                RED
            } else {
                BLUE
            })

        holder.idView.setOnClickListener { v ->
            if (v is TextView) {
                context.switch(v.text.toString().toInt(), v.currentTextColor)
            }
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idView: TextView = view.findViewById(R.id.item_number)

    }
}