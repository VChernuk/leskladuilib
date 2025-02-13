package com.kophe.leskladuilib.admin.locations.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.kophe.leskladlib.repository.common.Sublocation
import com.kophe.leskladuilib.OnItemSelectedListener

class SublocationsAdapter(
    private val listener: OnItemSelectedListener<Sublocation>?
) : Adapter<SublocationViewHolder>() {

    // Список елементів, які будуть відображені в адаптері
    var items: List<Sublocation> = emptyList()
        set(value) {
            field = value
            // Встановлюємо visibleItems в перші три елементи зі списку items
            notifyDataSetChanged()
        }


    // Кількість елементів в RecyclerView
    override fun getItemCount() = items.count()

    // Зв'язує елемент зі списку з відповідним ViewHolder
    override fun onBindViewHolder(holder: SublocationViewHolder, position: Int) =
        holder.bind(position, items[position])

    // Створює новий ViewHolder для елемента
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SublocationViewHolder.create(parent, listener = listener)

}
