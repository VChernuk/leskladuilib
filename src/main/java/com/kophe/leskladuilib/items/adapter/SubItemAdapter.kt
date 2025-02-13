package com.kophe.leskladuilib.items.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kophe.leskladlib.repository.common.Item
import com.kophe.leskladuilib.OnItemSelectedListener

class SubItemAdapter(
    private val listener: OnItemSelectedListener<Item>?
) : RecyclerView.Adapter<SubItemViewHolder>() {

    // Список елементів, які будуть відображені в адаптері
    var items: List<Item> = emptyList()
        set(value) {
            field = value
            // Встановлюємо visibleItems в перші три елементи зі списку items
            notifyDataSetChanged()
        }

    // Кількість елементів в RecyclerView
    override fun getItemCount() = items.count()

    // Зв'язує елемент зі списку з відповідним ViewHolder
    override fun onBindViewHolder(holder: SubItemViewHolder, position: Int) =
        holder.bind(position, items[position])

    // Створює новий ViewHolder для елемента
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SubItemViewHolder.create(parent, listener = listener)

}
