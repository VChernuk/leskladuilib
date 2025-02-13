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
) : RecyclerView.Adapter<DeliveryNotesAdapter.DeliveryNoteViewHolder>() {

    inner class DeliveryNoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val numberTextView: TextView = itemView.findViewById(R.id.tvDeliveryNoteNumber)
        private val dateTextView: TextView = itemView.findViewById(R.id.tvDeliveryNoteDate)
        private val signatoryTextView: TextView = itemView.findViewById(R.id.tvDeliveryNoteSignatory)

        fun bind(deliveryNote: DeliveryNote) {
            numberTextView.text = deliveryNote.dn_number ?: "-"
            dateTextView.text = deliveryNote.date?.toString() ?: "-"
            signatoryTextView.text = deliveryNote.responsible_person ?: "-"
            itemView.setOnClickListener { onItemClick(deliveryNote) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeliveryNoteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_delivery_note_item, parent, false)
        return DeliveryNoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: DeliveryNoteViewHolder, position: Int) {
        holder.bind(deliveryNotes[position])
    }

    override fun getItemCount(): Int = deliveryNotes.size
}
