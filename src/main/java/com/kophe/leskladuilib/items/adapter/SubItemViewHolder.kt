package com.kophe.leskladuilib.items.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kophe.leskladlib.repository.common.Item
import com.kophe.leskladuilib.OnItemSelectedListener
import com.kophe.leskladuilib.R

class SubItemViewHolder(
    view: View, private val listener: OnItemSelectedListener<Item>?
) : RecyclerView.ViewHolder(view) {

    private val title = view.findViewById<TextView>(R.id.title)

    fun bind(position: Int, item: Item) {
        title.text = "${position + 1}. ${item.titleString()}"
        itemView.setOnClickListener { listener?.selectItem(item) }
    }

    companion object {

        fun create(parent: ViewGroup, listener: OnItemSelectedListener<Item>?) = SubItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_sublist_row, parent, false),
            listener
        )

    }

}
