package com.kophe.leskladuilib.deliverynote.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.kophe.leskladlib.repository.common.CommonItem
import com.kophe.leskladuilib.OnItemSelectedListener

class DeliveryNoteItemsAdapter(
    private val listener: OnItemSelectedListener<CommonItem>?
) : Adapter<DeliveryNoteItemViewHolder>() {

    // Список елементів, які будуть відображені в адаптері
    var items: List<CommonItem> = emptyList()
        set(value) {
            field = value
            // Встановлюємо visibleItems в перші три елементи зі списку items
            visibleItems = value.take(3)
            notifyDataSetChanged()
        }

    // Список елементів, які будуть відображені в RecyclerView
    private var visibleItems: List<CommonItem> = emptyList()

    // Кількість елементів в RecyclerView
    override fun getItemCount() = visibleItems.count()

    // Зв'язує елемент зі списку з відповідним ViewHolder
    override fun onBindViewHolder(holder: DeliveryNoteItemViewHolder, position: Int) =
        holder.bind(position + 1, visibleItems[position])

    // Створює новий ViewHolder для елемента
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DeliveryNoteItemViewHolder.create(parent, listener = listener)

}
