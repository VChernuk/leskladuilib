package com.kophe.leskladuilib.admin.createlocation

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

class SublocationsViewHolder(
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
        else removeItem.visibility = GONE
        itemView.setOnClickListener { clickListener?.selectItem(item) }
        itemView.findViewById<View>(R.id.quantityControls).visibility = GONE
    }

    companion object {

        fun create(
            parent: ViewGroup,
            clickListener: OnItemSelectedListener<CommonItem>?,
            removeListener: OnItemSelectedListener<CommonItem>?,
            allowRemove: Boolean
        ) = SublocationsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.selected_issuance_item_row, parent, false),
            clickListener, removeListener, allowRemove,
        )

    }

}
