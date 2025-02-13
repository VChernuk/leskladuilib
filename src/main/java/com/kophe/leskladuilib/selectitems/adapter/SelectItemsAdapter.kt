package com.kophe.leskladuilib.selectitems.adapter

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.kophe.leskladlib.repository.common.Item
import com.kophe.leskladuilib.OnItemSelectedListener

class SelectItemsAdapter(private val listener: OnItemSelectedListener<Item>?) :
    Adapter<SelectItemViewHolder>(), OnItemSelectedListener<Item> {

    val selectedItems = mutableListOf<Item>()
    var items: List<Item> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: SelectItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item, selectedItems.find { it.firestoreId == item.firestoreId } != null)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SelectItemViewHolder.create(parent, this)

    override fun selectItem(item: Item) {
        Log.d("test", "selected items 1: $selectedItems")
        selectedItems.find { it.firestoreId == item.firestoreId }?.let { selectedItems.remove(it) }
            ?: run { selectedItems.add(item) }
        notifyItemChanged(items.indexOf(item))
        Log.d("test", "selected items 2: $selectedItems")
        listener?.selectItem(item)
    }

}
