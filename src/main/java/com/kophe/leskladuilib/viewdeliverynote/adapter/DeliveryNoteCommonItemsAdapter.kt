package com.kophe.leskladuilib.viewdeliverynote.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.kophe.leskladlib.repository.common.CommonItem
import com.kophe.leskladuilib.OnItemSelectedListener

class DeliveryNoteCommonItemsAdapter(
    private val clickListener: OnItemSelectedListener<CommonItem>?,
    private val removeListener: OnItemSelectedListener<CommonItem>?,
    private val allowRemove: Boolean
) : Adapter<DeliveryNoteCommonItemViewHolder>() {

    var items: List<CommonItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: DeliveryNoteCommonItemViewHolder, position: Int) =
        holder.bind(items[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DeliveryNoteCommonItemViewHolder.create(parent, clickListener, removeListener, allowRemove)

}
