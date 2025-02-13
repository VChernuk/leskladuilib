package com.kophe.leskladuilib.admin.backups.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.kophe.leskladuilib.OnItemSelectedListener
import com.kophe.leskladuilib.R

class BackupsViewHolder(view: View, private val listener: OnItemSelectedListener<String>?) :
    ViewHolder(view) {

    private val title by lazy { view.findViewById<TextView>(R.id.title) }
    private val remainingItemText by lazy { view.findViewById<TextView>(R.id.remainingItemsText) }

    fun bind(item: String) {
        title.text = item
        itemView.setOnClickListener { listener?.selectItem(item) }
        remainingItemText.visibility = View.GONE
    }

    companion object {

        fun create(
            parent: ViewGroup,
            listener: OnItemSelectedListener<String>?,
        ) = BackupsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_issuance_row, parent, false),
            listener
        )

    }

}
