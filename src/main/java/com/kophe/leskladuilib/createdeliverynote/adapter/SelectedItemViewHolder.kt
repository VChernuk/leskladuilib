package com.kophe.leskladuilib.createdeliverynote.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.GONE
import androidx.recyclerview.widget.RecyclerView.VISIBLE
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.kophe.leskladlib.repository.common.Item
import com.kophe.leskladuilib.OnItemSelectedListener
import com.kophe.leskladuilib.R

class SelectedItemViewHolder(
    view: View,
    private val removeListener: OnItemSelectedListener<Item>?,
    private val minusClickListener: OnItemSelectedListener<Item>?,
    private val plusClickListener: OnItemSelectedListener<Item>?
) : ViewHolder(view) {

    private val title = view.findViewById<TextView>(R.id.title)
    private val removeItem = view.findViewById<ImageButton>(R.id.removeItemButton)
    private val quantityControls = view.findViewById<View>(R.id.quantityControls)
    private val minus = view.findViewById<View>(R.id.minus)
    private val plus = view.findViewById<View>(R.id.plus)
    private val quantity = view.findViewById<TextView>(R.id.quantity)
    private val measurement = view.findViewById<TextView>(R.id.measurement)

    fun bind(item: Item) {
        title.text = item.titleString()
        removeItem.setOnClickListener { removeListener?.selectItem(item) }
        quantityControls.visibility = if (item.quantity != null) VISIBLE else GONE
        item.quantity?.let { itemQuantity ->
            quantity.text = "${itemQuantity.quantity}"
            measurement.text = itemQuantity.measurement
            minus.setOnClickListener { minusClickListener?.selectItem(item) }
            plus.setOnClickListener { plusClickListener?.selectItem(item) }
            minus.isEnabled = itemQuantity.quantity > 1
        }
    }

    companion object {

        fun create(
            parent: ViewGroup,
            removeListener: OnItemSelectedListener<Item>?,
            minusClickListener: OnItemSelectedListener<Item>?,
            plusClickListener: OnItemSelectedListener<Item>?
        ) = SelectedItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.selected_deliverynote_item_row, parent, false),
            removeListener,
            minusClickListener,
            plusClickListener
        )

    }

}
