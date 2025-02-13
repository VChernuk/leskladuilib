package com.kophe.leskladuilib.admin.categories.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.kophe.leskladlib.repository.common.Subcategory
import com.kophe.leskladuilib.OnItemSelectedListener

class SubcategoriesAdapter(
    private val listener: OnItemSelectedListener<Subcategory>?
) : Adapter<SubcategoryViewHolder>() {

    // Список елементів, які будуть відображені в адаптері
    var items: List<Subcategory> = emptyList()
        set(value) {
            field = value
            // Встановлюємо visibleItems в перші три елементи зі списку items
            notifyDataSetChanged()
        }


    // Кількість елементів в RecyclerView
    override fun getItemCount() = items.count()

    // Зв'язує елемент зі списку з відповідним ViewHolder
    override fun onBindViewHolder(holder: SubcategoryViewHolder, position: Int) =
        holder.bind(position, items[position])

    // Створює новий ViewHolder для елемента
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SubcategoryViewHolder.create(parent, listener = listener)

}
