package com.kophe.leskladuilib.items.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VISIBLE
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.kophe.leskladlib.repository.common.Item
import com.kophe.leskladuilib.OnItemSelectedListener
import com.kophe.leskladuilib.R

class ItemViewHolder(
    view: View, private val listener: OnItemSelectedListener<Item>?
) : ViewHolder(view) {

    private val title = view.findViewById<TextView>(R.id.title)
    private val locationBG = view.findViewById<ImageView>(R.id.locationBG)
    private val subtitle = view.findViewById<TextView>(R.id.subtitle)
    private val ownership = view.findViewById<TextView>(R.id.ownership)
    private val location = view.findViewById<TextView>(R.id.location)
    private val shapeDrawable =
        ContextCompat.getDrawable(itemView.context, R.drawable.bg_round_view)
    private val subItemsList = view.findViewById<RecyclerView>(R.id.subItemsList)
    private val setOptions = view.findViewById<TextView>(R.id.setOptionTV)

    fun bind(item: Item) {
        title.text = item.titleString()
        item.location?.let { itemLocation ->
            location.text = if (itemLocation.title.length > 3) {
                itemLocation.title.substring(0, 3).uppercase()
            } else {
                itemLocation.title.uppercase()
            }
        }
        itemView.setOnClickListener { listener?.selectItem(item) }
        ownership.text = item.ownershipType?.title
        item.location?.let {
            val colors = listOf(
                R.color.colorAccent,
                R.color.colorBlue,
                R.color.colorGreen,
                R.color.colorRed,
                R.color.colorPrimary,
                R.color.colorLightBlue,
                R.color.colorOrange
            )
            val colorIndex = kotlin.math.abs(it.hashCode() % colors.size)
            shapeDrawable?.setTint(ContextCompat.getColor(itemView.context, colors[colorIndex]))
            locationBG.setImageDrawable(shapeDrawable)
        } ?: run {
            location.visibility = GONE
        }
        item.createdDate?.let {
            subtitle.text = "Створено: $it"
            subtitle.visibility = VISIBLE
        } ?: run { subtitle.visibility = GONE }
        val itemSetOptions = item.setOptions ?: run {
            setOptions.visibility = GONE
            subItemsList.visibility = GONE
            return
        }
        if (itemSetOptions.subItems.isEmpty()) {
            subItemsList.visibility = GONE
        } else {
            subItemsList.visibility = VISIBLE
            val subItemsAdapter = SubItemAdapter(listener)
            subItemsAdapter.items = itemSetOptions.subItems.toList()
            subItemsList.adapter = subItemsAdapter
        }
        setOptions.visibility = VISIBLE
        setOptions.text =
            if (!itemSetOptions.parentItem?.firestoreId.isNullOrEmpty()) "В комплекті" else "Комплект"
    }

    companion object {

        fun create(
            parent: ViewGroup, listener: OnItemSelectedListener<Item>?
        ) = ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false), listener
        )

    }

}
