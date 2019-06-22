package com.appsx.eventsapplication.data.model

interface IEventData {
    fun getId(): Int
    fun getName(): String
    fun isActive(): Boolean
}