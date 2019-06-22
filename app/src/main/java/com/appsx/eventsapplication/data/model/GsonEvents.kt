package com.appsx.eventsapplication.data.model

import com.google.gson.annotations.SerializedName

class GsonEvents(
    @SerializedName("events") private val events: List<GsonEventData>
) : IEvents {

    override fun getEvents(): List<IEventData> {
        return events
    }
}