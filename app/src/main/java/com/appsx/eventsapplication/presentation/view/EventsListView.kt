package com.appsx.eventsapplication.presentation.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.appsx.eventsapplication.presentation.model.IEventDisplayModel

class EventsListView(
    private val noEventsInfoTv: TextView,
    private val eventsListRv: RecyclerView
) : IEventsListView {

    override fun showEvents(events: List<IEventDisplayModel>) {
        noEventsInfoTv.visibility = View.INVISIBLE
        eventsListRv.adapter = EventsListRVAdapter(events)
    }
}