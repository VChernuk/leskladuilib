package com.kophe.leskladuilib.deliverynotes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VISIBLE
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.kophe.leskladlib.repository.common.DeliveryNote
import com.kophe.leskladuilib.OnItemSelectedListener
import com.kophe.leskladuilib.R

class DeliveryNoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvDeliveryNoteNumber: TextView = itemView.findViewById(R.id.tvDeliveryNoteNumber)
    private val tvDeliveryNoteDate: TextView = itemView.findViewById(R.id.tvDeliveryNoteDate)
    private val tvDeliveryNoteDepartment: TextView = itemView.findViewById(R.id.tvDeliveryNoteDepartment)
    private val tvDeliveryNoteSignatory: TextView = itemView.findViewById(R.id.tvDeliveryNoteSignatory)

    fun bind(deliveryNote: DeliveryNote, onItemClick: (DeliveryNote) -> Unit) {
        tvDeliveryNoteNumber.text = deliveryNote.number
        tvDeliveryNoteDate.text = deliveryNote.date.toString()
        tvDeliveryNoteDepartment.text = deliveryNote.location.title
        tvDeliveryNoteSignatory.text = deliveryNote.responsiblePerson

        itemView.setOnClickListener {
            onItemClick(deliveryNote)
        }
    }
}
