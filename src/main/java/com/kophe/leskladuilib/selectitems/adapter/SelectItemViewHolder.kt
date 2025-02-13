package com.kophe.leskladuilib.selectitems.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.kophe.leskladlib.repository.common.Item
import com.kophe.leskladuilib.OnItemSelectedListener
import com.kophe.leskladuilib.R

class SelectItemViewHolder(
    view: View, private val listener: OnItemSelectedListener<Item>?
) : ViewHolder(view) {

    private val title = view.findViewById<TextView>(R.id.title)
    private val location = view.findViewById<TextView>(R.id.location)
    private val ownership = view.findViewById<TextView>(R.id.ownership)
    private val selectedCheckbox = view.findViewById<CheckBox>(R.id.selectedCheckbox)

    fun bind(item: Item, selected: Boolean) {
        title.text = item.titleString()
        location.text = item.location?.title + (item.sublocation?.title?.let { "/$it" } ?: "")
        ownership.text = item.ownershipType?.title
        itemView.setOnClickListener { listener?.selectItem(item) }
        selectedCheckbox.isChecked = selected
    }

    companion object {

        fun create(parent: ViewGroup, listener: OnItemSelectedListener<Item>?) =
            SelectItemViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.select_item_row, parent, false), listener
            )

    }

}
