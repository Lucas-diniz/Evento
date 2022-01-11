package com.lucas.diniz.events.features.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lucas.diniz.R
import com.lucas.diniz.events.dto.Events
import com.lucas.diniz.extension.function.toDataFormatted
import com.lucas.diniz.extension.function.toPrice
import com.squareup.picasso.Picasso

class EventListAdapter(private val picasso: Picasso) : RecyclerView.Adapter<EventListAdapter.EventHolder>() {

    private var listener: OnItemClickListener? = null
    var listEvent: List<Events> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventHolder {

        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_event, parent, false)

        return EventHolder(itemView)
    }

    override fun onBindViewHolder(holder: EventHolder, position: Int) {
        val event = listEvent[position]

        picasso.load(event.image).into(holder.image)
        holder.tile.text = event.title
        holder.price.text = event.price.toPrice()
        holder.data.text = event.date.toDataFormatted(DATA_FORMAT)

        initListeners(holder, event)
    }

    private fun initListeners(holder: EventHolder, event: Events) {
        holder.checkIn.setOnClickListener {
            listener?.onItemClickCheckIn(event.id)
        }

        holder.info.setOnClickListener {
            listener?.onItemClickInfo(event.id)
        }
    }

    override fun getItemCount(): Int {
        return listEvent.size
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        this.listener = listener
    }

    inner class EventHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.image)
        val tile: TextView = itemView.findViewById(R.id.tile)
        val price: TextView = itemView.findViewById(R.id.price)
        val data: TextView = itemView.findViewById(R.id.data)
        val checkIn: Button = itemView.findViewById(R.id.checkin)
        val info: Button = itemView.findViewById(R.id.info)

    }

    companion object {
        const val DATA_FORMAT = "dd/MM/yyyy HH:mm"
    }

    interface OnItemClickListener {
        fun onItemClickCheckIn(id: Int)
        fun onItemClickInfo(id: Int)
    }
}