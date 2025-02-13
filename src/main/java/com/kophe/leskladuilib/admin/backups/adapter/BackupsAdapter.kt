package com.kophe.leskladuilib.admin.backups.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.kophe.leskladuilib.OnItemSelectedListener

class BackupsAdapter(
    private val listener: OnItemSelectedListener<String>?
) : Adapter<BackupsViewHolder>() {

    var items: List<String> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = items.count()

    override fun onBindViewHolder(holder: BackupsViewHolder, position: Int) =
        holder.bind(items[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BackupsViewHolder.create(parent, listener)

}
