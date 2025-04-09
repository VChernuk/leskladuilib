package com.kophe.leskladuilib.createdeliverynote.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.kophe.leskladlib.repository.common.Item
import com.kophe.leskladuilib.OnItemSelectedListener

class SelectedItemsAdapter(
    private val removeListener: OnItemSelectedListener<Item>?,
    private val minusClickListener: OnItemSelectedListener<Item>?,
    private val plusClickListener: OnItemSelectedListener<Item>?
) : Adapter<SelectedItemViewHolder>() {

    var items: List<Item> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: SelectedItemViewHolder, position: Int) =
        holder.bind(items[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SelectedItemViewHolder.create(parent, removeListener, minusClickListener, plusClickListener)

}
