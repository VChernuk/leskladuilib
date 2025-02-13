package com.kophe.leskladuilib.admin.categories.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.kophe.leskladlib.repository.common.Subcategory
import com.kophe.leskladuilib.OnItemSelectedListener
import com.kophe.leskladuilib.R

class SubcategoryViewHolder(
    view: View, private val listener: OnItemSelectedListener<Subcategory>?
) : ViewHolder(view) {

    private val title = view.findViewById<TextView>(R.id.title)

    fun bind(position: Int, item: Subcategory) {
        title.text = "${position + 1}. ${item.title}"
        itemView.setOnClickListener { listener?.selectItem(item) }
    }

    companion object {

        fun create(parent: ViewGroup, listener: OnItemSelectedListener<Subcategory>?) =
            SubcategoryViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_sublist_row, parent, false), listener
            )

    }

}
