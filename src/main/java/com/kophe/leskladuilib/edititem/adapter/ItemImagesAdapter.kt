package com.kophe.leskladuilib.edititem.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.kophe.leskladlib.repository.common.ItemImage
import com.kophe.leskladuilib.OnItemSelectedListener

class ItemImagesAdapter(private val listener: OnItemSelectedListener<ItemImage>?) :
    Adapter<ItemImageViewHolder>(), OnItemSelectedListener<ItemImage> {

    var items: List<ItemImage> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: ItemImageViewHolder, position: Int) =
        holder.bind(items[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ItemImageViewHolder.create(parent, this)

    override fun selectItem(item: ItemImage) {
        listener?.selectItem(item)
    }

}
