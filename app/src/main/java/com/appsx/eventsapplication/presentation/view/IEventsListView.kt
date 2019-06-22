package com.appsx.eventsapplication.presentation.view

import com.appsx.eventsapplication.presentation.model.IEventDisplayModel

interface IEventsListView {
    fun showEvents(events : List<IEventDisplayModel>)
}