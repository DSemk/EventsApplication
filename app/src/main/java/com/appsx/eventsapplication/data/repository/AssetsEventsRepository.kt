package com.appsx.eventsapplication.data.repository

import android.content.res.AssetManager
import com.appsx.eventsapplication.data.model.GsonEvents
import com.appsx.eventsapplication.data.model.IEventData
import com.appsx.eventsapplication.data.repository.exception.ReadAssetFileException
import com.google.gson.Gson
import java.io.InputStream

class AssetsEventsRepository(
    private val assetManager: AssetManager
) : IEventsRepository {

    private val jsonFilePath = "data/events.json"

    private var eventDataList: List<IEventData>? = null

    override fun load(): List<IEventData> {
        if (eventDataList == null) {
            val inputStream = assetManager.open(jsonFilePath)
            val resultString: String

            try {
                resultString = inputStreamToString(inputStream)
                inputStream.close()
            } catch (e: Exception) {
                inputStream.close()
                throw ReadAssetFileException(
                    this::class.java.simpleName +
                            ": Error reading $jsonFilePath" +
                            "\n" + e.message
                )
            }

            if (resultString.isEmpty()) {
                eventDataList = mutableListOf()
            } else {
                val events = Gson().fromJson(resultString, GsonEvents::class.java)
                eventDataList = events.getEvents()
            }
        }

        return eventDataList!!
    }

    private fun inputStreamToString(inputStream: InputStream): String {
        val bytes = ByteArray(inputStream.available())
        inputStream.read(bytes, 0, bytes.size)
        return String(bytes)
    }
}