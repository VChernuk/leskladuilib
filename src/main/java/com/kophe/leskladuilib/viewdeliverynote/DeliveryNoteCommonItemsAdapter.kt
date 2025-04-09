package com.kophe.leskladuilib.viewissuance.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.kophe.leskladlib.repository.common.CommonItem
import com.kophe.leskladuilib.OnItemSelectedListener

class IssuanceCommonItemsAdapter(
    private val clickListener: OnItemSelectedListener<CommonItem>?,
    private val removeListener: OnItemSelectedListener<CommonItem>?,
    private val allowRemove: Boolean
) : Adapter<IssuanceCommonItemViewHolder>() {

    var items: List<CommonItem> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: IssuanceCommonItemViewHolder, position: Int) =
        holder.bind(items[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        IssuanceCommonItemViewHolder.create(parent, clickListener, removeListener, allowRemove)

}
