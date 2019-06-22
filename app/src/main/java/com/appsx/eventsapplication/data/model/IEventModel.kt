package com.appsx.eventsapplication.data.model

interface IEventModel {
    fun getId(): Int
    fun getName(): String
    fun isActive(): Boolean
}