package com.kophe.leskladuilib.edititem.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.kophe.leskladlib.repository.common.CommonItem
import com.kophe.leskladuilib.OnItemSelectedListener

class CommonItemAdapter(private val listener: OnItemSelectedListener<CommonItem>?) :
    Adapter<CommonItemViewHolder>(), OnItemSelectedListener<CommonItem> {

    var items: List<CommonItem> = emptyList()
        set(value) {
            field = value.reversed()
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: CommonItemViewHolder, position: Int) =
        holder.bind(items[position])

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): CommonItemViewHolder = CommonItemViewHolder.create(parent, this)

    override fun selectItem(item: CommonItem) {
        listener?.selectItem(item)
    }

}
