package com.appsx.eventsapplication.presentation.view

import android.content.res.Resources
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.appsx.eventsapplication.R
import com.appsx.eventsapplication.presentation.model.IEventDisplayModel

class EventsListView(
    private val resources: Resources,
    private val eventsStatusTv: TextView,
    private val eventsListRv: RecyclerView
) : IEventsListView {
    override fun showReadErrorMessage() {
        eventsStatusTv.text = resources.getText(R.string.reading_events_error)
    }

    override fun showEvents(events: List<IEventDisplayModel>) {
        eventsStatusTv.visibility = View.INVISIBLE
        eventsListRv.adapter = EventsListRVAdapter(events)
    }
}