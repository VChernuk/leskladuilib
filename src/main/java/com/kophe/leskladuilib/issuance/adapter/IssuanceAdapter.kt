package com.kophe.leskladuilib.issuance.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.kophe.leskladuilib.issuance.adapter.IssuanceViewHolder
import com.kophe.leskladlib.repository.common.CommonItem
import com.kophe.leskladlib.repository.common.Issuance
import com.kophe.leskladuilib.OnItemSelectedListener

class IssuanceAdapter(
    private val listener: OnItemSelectedListener<Issuance>?,
    private val itemListener: OnItemSelectedListener<CommonItem>?
) : Adapter<IssuanceViewHolder>() {

    var items: List<Issuance> = emptyList()
        set(value) {
            field = value.sorted().reversed()
            notifyDataSetChanged()
        }

    override fun getItemCount() = items.count()

    override fun onBindViewHolder(holder: IssuanceViewHolder, position: Int) =
        holder.bind(items[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        IssuanceViewHolder.create(parent, listener = listener, itemListener)

}
