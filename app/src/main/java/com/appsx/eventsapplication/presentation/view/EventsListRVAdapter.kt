package com.appsx.eventsapplication.presentation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.appsx.eventsapplication.R
import com.appsx.eventsapplication.presentation.model.IEventDisplayModel

class EventsListRVAdapter(
    private val events: List<IEventDisplayModel>
) : RecyclerView.Adapter<EventsListRVAdapter.EventViewHolder>() {

    override fun getItemCount(): Int {
        return events.size
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.eventName.text = events[position].getName()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_event, parent, false)

        return EventViewHolder(v)
    }


    class EventViewHolder internal constructor(v: View) : RecyclerView.ViewHolder(v) {
        val eventName: TextView = v.findViewById(R.id.tv_item_event_name)
    }
}