package com.kophe.leskladuilib.deliverynote.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.kophe.leskladuilib.deliverynote.adapter.DeliveryNoteViewHolder
import com.kophe.leskladlib.repository.common.CommonItem
import com.kophe.leskladlib.repository.common.DeliveryNote
import com.kophe.leskladuilib.OnItemSelectedListener

class DeliveryNoteAdapter(
    private val listener: OnItemSelectedListener<DeliveryNote>?,
    private val itemListener: OnItemSelectedListener<CommonItem>?
) : Adapter<DeliveryNoteViewHolder>() {

    var items: List<DeliveryNote> = emptyList()
        set(value) {
            field = value.sorted().reversed()
            notifyDataSetChanged()
        }

    override fun getItemCount() = items.count()

    override fun onBindViewHolder(holder: DeliveryNoteViewHolder, position: Int) =
        holder.bind(items[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DeliveryNoteViewHolder.create(parent, listener = listener, itemListener)

}
