package com.kophe.leskladuilib.issuance.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.kophe.leskladlib.repository.common.CommonItem
import com.kophe.leskladlib.repository.common.Issuance
import com.kophe.leskladuilib.OnItemSelectedListener
import com.kophe.leskladuilib.R

class IssuanceViewHolder(
    view: View,
    private val listener: OnItemSelectedListener<Issuance>?,
    private val issuanceItemListener: OnItemSelectedListener<CommonItem>?
) : ViewHolder(view) {

    // Оголошуємо змінні для елементів UI
    private val title = view.findViewById<TextView>(R.id.title)
    private val items = view.findViewById<RecyclerView>(R.id.issuanceItemsList)
    private val remainingItemText = view.findViewById<TextView>(R.id.remainingItemsText)

    // Метод, що прив'язує дані до елементів UI
    fun bind(item: Issuance) {
        // Встановлюємо текст для заголовку
        title.text =
            buildString {
                append(item.date)
                append("/")
                append(item.from)
                append("->")
                append((item.responsibleUnit?.title?.let { it + "/" }
                    ?: ""))
                append(item.to)
                append((item.receiverCallSign?.let { "/$it" } ?: ""))
            }
        // Встановлюємо обробник кліку на елементі списку
        itemView.setOnClickListener { listener?.selectItem(item) }
        val adapter = IssuanceItemsAdapter(issuanceItemListener)
        adapter.items = item.items
        items.adapter = adapter

        // Встановлюємо текст та видимість для поля, яке відображає кількість залишених елементів, якщо їх більше 3
        if (item.items.size > 3) {
            val remainingItemCount = item.items.size - 3
            val message = "Ще $remainingItemCount позицій"
            remainingItemText.text = message
            remainingItemText.visibility = View.VISIBLE
        } else {
            remainingItemText.visibility = View.GONE
        }
        remainingItemText.paint.isUnderlineText = true
    }

    companion object {

        // Метод, що створює новий екземпляр IssuanceViewHolder
        fun create(
            parent: ViewGroup,
            listener: OnItemSelectedListener<Issuance>?,
            issuanceItemListener: OnItemSelectedListener<CommonItem>?
        ) = IssuanceViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_issuance_row, parent, false),
            listener,
            issuanceItemListener
        )

    }

}
