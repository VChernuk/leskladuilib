package com.kophe.leskladuilib.edititem.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.kophe.leskladlib.repository.common.ItemImage
import com.kophe.leskladuilib.OnItemSelectedListener
import com.kophe.leskladuilib.R

class ItemImageViewHolder(
    view: View, private val listener: OnItemSelectedListener<ItemImage>?
) : ViewHolder(view) {

    private val image = view.findViewById<ImageView>(R.id.itemImage)

    fun bind(item: ItemImage) {
        itemView.setOnClickListener { listener?.selectItem(item) }
        val storageReference = Firebase.storage.getReferenceFromUrl(item.url)
        Glide.with(itemView /* context */).load(storageReference).into(image)
    }

    companion object {

        fun create(
            parent: ViewGroup, listener: OnItemSelectedListener<ItemImage>?
        ) = ItemImageViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.image_row, parent, false), listener
        )

    }

}
