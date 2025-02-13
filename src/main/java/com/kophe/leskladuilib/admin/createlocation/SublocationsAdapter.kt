package com.kophe.leskladuilib.admin.createlocation

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.kophe.leskladlib.repository.common.CommonItem
import com.kophe.leskladuilib.OnItemSelectedListener

class SublocationsAdapter(
    private val clickListener: OnItemSelectedListener<CommonItem>?,
    private val removeListener: OnItemSelectedListener<CommonItem>?,
    private val allowRemove: Boolean
) : Adapter<SublocationsViewHolder>() {

    var items: List<CommonItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: SublocationsViewHolder, position: Int) =
        holder.bind(items[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SublocationsViewHolder.create(parent, clickListener, removeListener, allowRemove)

}
