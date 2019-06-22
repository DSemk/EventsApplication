package com.appsx.eventsapplication.data.repository

import com.appsx.eventsapplication.data.model.IEventData

interface IEventsRepository {
    fun load(): List<IEventData>
}