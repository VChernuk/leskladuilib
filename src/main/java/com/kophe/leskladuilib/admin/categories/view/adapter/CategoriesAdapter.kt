package com.kophe.leskladuilib.admin.categories.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.kophe.leskladlib.repository.common.Category
import com.kophe.leskladlib.repository.common.Subcategory
import com.kophe.leskladuilib.OnItemSelectedListener

class CategoriesAdapter(
    private val listener: OnItemSelectedListener<Category>?,
    private val itemListener: OnItemSelectedListener<Subcategory>?
) : Adapter<CategoryViewHolder>() {

    var items: List<Category> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = items.count()

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) =
        holder.bind(items[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CategoryViewHolder.create(parent, listener, itemListener)

}
