package com.kophe.leskladuilib.deliverynote.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.kophe.leskladlib.repository.common.CommonItem
import com.kophe.leskladuilib.OnItemSelectedListener
import com.kophe.leskladuilib.R

class DeliveryNoteItemViewHolder(
    view: View, private val listener: OnItemSelectedListener<CommonItem>?
) : ViewHolder(view) {

    private val title = view.findViewById<TextView>(R.id.title)

    fun bind(position: Int, item: CommonItem) {
        title.text = buildString {
        append(position)
        append(". ")
        append(item.title)
    }
        itemView.setOnClickListener { listener?.selectItem(item) }
    }

    companion object {

        fun create(parent: ViewGroup, listener: OnItemSelectedListener<CommonItem>?) =
            DeliveryNoteItemViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_sublist_row, parent, false), listener
            )

    }

}
