package com.kophe.leskladuilib.admin.categories.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.kophe.leskladlib.repository.common.Category
import com.kophe.leskladlib.repository.common.Subcategory
import com.kophe.leskladuilib.OnItemSelectedListener
import com.kophe.leskladuilib.R

class CategoryViewHolder(
    view: View,
    private val listener: OnItemSelectedListener<Category>?,
    private val issuanceItemListener: OnItemSelectedListener<Subcategory>?
) : ViewHolder(view) {

    // Оголошуємо змінні для елементів UI
    private val title by lazy { view.findViewById<TextView>(R.id.title) }
    private val items by lazy { view.findViewById<RecyclerView>(R.id.issuanceItemsList) }
    private val remainingItemText by lazy { view.findViewById<TextView>(R.id.remainingItemsText) }
    private val adapter by lazy { SubcategoriesAdapter(issuanceItemListener) }

    // Метод, що прив'язує дані до елементів UI
    fun bind(item: Category) {
        // Встановлюємо текст для заголовку
        title.text = item.title
        // Встановлюємо обробник кліку на елементі списку
        itemView.setOnClickListener { listener?.selectItem(item) }
        adapter.items = item.subcategories
        items.adapter = adapter
        remainingItemText.visibility = View.GONE
    }

    companion object {

        // Метод, що створює новий екземпляр IssuanceViewHolder
        fun create(
            parent: ViewGroup,
            listener: OnItemSelectedListener<Category>?,
            issuanceItemListener: OnItemSelectedListener<Subcategory>?
        ) = CategoryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_issuance_row, parent, false),
            listener,
            issuanceItemListener
        )

    }

}
