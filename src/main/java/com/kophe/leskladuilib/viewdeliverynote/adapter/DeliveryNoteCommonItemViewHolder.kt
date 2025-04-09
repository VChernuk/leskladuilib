package com.kophe.leskladuilib.viewdeliverynote.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.GONE
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.kophe.leskladlib.repository.common.CommonItem
import com.kophe.leskladuilib.OnItemSelectedListener
import com.kophe.leskladuilib.R

class DeliveryNoteCommonItemViewHolder(
    view: View,
    private val clickListener: OnItemSelectedListener<CommonItem>?,
    private val removeListener: OnItemSelectedListener<CommonItem>?,
    private val allowRemove: Boolean,

    ) : ViewHolder(view) {

    private val title = view.findViewById<TextView>(R.id.title)
    private val removeItem = view.findViewById<ImageButton>(R.id.removeItemButton)

    fun bind(item: CommonItem) {
        title.text = item.title
        if (allowRemove) removeItem.setOnClickListener { removeListener?.selectItem(item) }
        else {
            itemView.setOnClickListener { clickListener?.selectItem(item) }
            removeItem.visibility = GONE
        }
        itemView.findViewById<View>(R.id.quantityControls).visibility = GONE
    }

    companion object {

        fun create(
            parent: ViewGroup,
            clickListener: OnItemSelectedListener<CommonItem>?,
            removeListener: OnItemSelectedListener<CommonItem>?,
            allowRemove: Boolean
        ) = DeliveryNoteCommonItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.selected_deliverynote_item_row, parent, false),
            clickListener, removeListener, allowRemove,
        )

    }

}
