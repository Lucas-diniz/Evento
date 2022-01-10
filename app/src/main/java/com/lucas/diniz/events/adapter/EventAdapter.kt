package com.lucas.diniz.events.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lucas.diniz.R
import com.lucas.diniz.events.dto.Events
import com.lucas.diniz.extensionFunction.toDataFormatted
import com.squareup.picasso.Picasso

class EventAdapter : RecyclerView.Adapter<EventAdapter.EventHolder>() {

    var listEvent: List<Events> = ArrayList()
    lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventHolder {

        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_event, parent, false)

        return EventHolder(itemView)
    }

    override fun onBindViewHolder(holder: EventHolder, position: Int) {
        val event = listEvent[position]

        Picasso.with(mContext).load(event.image).into(holder.image)
        holder.tile.text = event.title
        holder.price.text = event.price.toString()
        holder.data.text = event.date.toDataFormatted(DATA_FORMAT)
    }

    override fun getItemCount(): Int {
        return listEvent.size
    }

    inner class EventHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.image)
        val tile: TextView = itemView.findViewById(R.id.tile)
        val price: TextView = itemView.findViewById(R.id.price)
        val data: TextView = itemView.findViewById(R.id.data)
    }

    companion object {
        const val DATA_FORMAT = "dd-MM-yyyy HH:mm"
    }
}