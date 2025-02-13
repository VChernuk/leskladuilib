package com.kophe.leskladuilib.admin.locations.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.kophe.leskladlib.repository.common.Location
import com.kophe.leskladlib.repository.common.Sublocation
import com.kophe.leskladuilib.OnItemSelectedListener
import com.kophe.leskladuilib.R

class LocationViewHolder(
    view: View,
    private val listener: OnItemSelectedListener<Location>?,
    private val issuanceItemListener: OnItemSelectedListener<Sublocation>?
) : ViewHolder(view) {

    // Оголошуємо змінні для елементів UI
    private val title by lazy { view.findViewById<TextView>(R.id.title) }
    private val items by lazy { view.findViewById<RecyclerView>(R.id.issuanceItemsList) }
    private val remainingItemText by lazy { view.findViewById<TextView>(R.id.remainingItemsText) }
    private val adapter by lazy { SublocationsAdapter(issuanceItemListener) }

    // Метод, що прив'язує дані до елементів UI
    fun bind(item: Location) {
        // Встановлюємо текст для заголовку
        title.text = item.title
        // Встановлюємо обробник кліку на елементі списку
        itemView.setOnClickListener { listener?.selectItem(item) }
        adapter.items = item.sublocations
        items.adapter = adapter
        remainingItemText.visibility = View.GONE
    }

    companion object {

        // Метод, що створює новий екземпляр IssuanceViewHolder
        fun create(
            parent: ViewGroup,
            listener: OnItemSelectedListener<Location>?,
            issuanceItemListener: OnItemSelectedListener<Sublocation>?
        ) = LocationViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_issuance_row, parent, false),
            listener,
            issuanceItemListener
        )

    }

}
