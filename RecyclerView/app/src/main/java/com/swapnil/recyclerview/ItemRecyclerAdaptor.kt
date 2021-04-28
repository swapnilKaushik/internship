package com.swapnil.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemRecyclerAdaptor(val context: Context, val items: ArrayList<ItemModel>):
    RecyclerView.Adapter<ItemRecyclerAdaptor.ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_single_row, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.itemName.text = item.name
        holder.itemEmail.text = item.email
        holder.itemPhone.text = item.phone_no
    }

    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var itemName = view.findViewById<TextView>(R.id.itemName)
        var itemEmail = view.findViewById<TextView>(R.id.itemEmail)
        var itemPhone = view.findViewById<TextView>(R.id.itemPhone)
    }
}