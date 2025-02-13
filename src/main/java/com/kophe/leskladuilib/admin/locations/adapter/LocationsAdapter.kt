package com.kophe.leskladuilib.admin.locations.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.kophe.leskladlib.repository.common.Location
import com.kophe.leskladlib.repository.common.Sublocation
import com.kophe.leskladuilib.OnItemSelectedListener

class LocationsAdapter(
    private val listener: OnItemSelectedListener<Location>?,
    private val itemListener: OnItemSelectedListener<Sublocation>?
) : Adapter<LocationViewHolder>() {

    var items: List<Location> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = items.count()

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) =
        holder.bind(items[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LocationViewHolder.create(parent, listener, itemListener)

}
