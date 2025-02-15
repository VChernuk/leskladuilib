package com.kophe.leskladuilib.deliverynotes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kophe.leskladlib.repository.common.DeliveryNote
import com.kophe.leskladuilib.R

class DeliveryNotesAdapter(
    private val deliveryNotes: List<DeliveryNote>,
    private val onItemClick: (DeliveryNote) -> Unit
) : RecyclerView.Adapter<DeliveryNoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeliveryNoteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_delivery_note, parent, false)
        return DeliveryNoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: DeliveryNoteViewHolder, position: Int) {
        holder.bind(deliveryNotes[position], onItemClick)
    }

    override fun getItemCount(): Int = deliveryNotes.size
}
