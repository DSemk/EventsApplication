package com.appsx.eventsapplication.data.model

import com.google.gson.annotations.SerializedName

class GsonEventModel(
    @SerializedName("id") private val id: Int,
    @SerializedName("name") private val name: String,
    @SerializedName("active") private val isActive: Boolean
) : IEventModel {

    override fun getId(): Int {
        return id
    }

    override fun getName(): String {
        return name
    }

    override fun isActive(): Boolean {
        return isActive
    }
}