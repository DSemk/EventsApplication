package com.appsx.eventsapplication.presentation.model

class EventDisplayModel(
    private val name: String
) : IEventDisplayModel {

    override fun getName(): String {
        return name
    }
}