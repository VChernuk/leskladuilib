package com.kophe.leskladuilib.edititem.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.GONE
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.kophe.leskladlib.repository.common.CommonItem
import com.kophe.leskladuilib.OnItemSelectedListener
import com.kophe.leskladuilib.R

class CommonItemViewHolder(
    view: View, private val listener: OnItemSelectedListener<CommonItem>?
) : ViewHolder(view) {

    private val title = view.findViewById<TextView>(R.id.title)
    private val locationBG = view.findViewById<View>(R.id.locationBG)
    private val location = view.findViewById<View>(R.id.location)
    private val subtitle = view.findViewById<View>(R.id.subtitle)

    fun bind(item: CommonItem) {
        itemView.setOnClickListener { listener?.selectItem(item) }
        title.text = item.title
        locationBG.visibility = GONE
        location.visibility = GONE
        subtitle.visibility = GONE
    }

    companion object {

        fun create(
            parent: ViewGroup, listener: OnItemSelectedListener<CommonItem>?
        ) = CommonItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false), listener
        )

    }

}
