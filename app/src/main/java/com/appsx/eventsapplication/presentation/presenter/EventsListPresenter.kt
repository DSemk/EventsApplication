package com.appsx.eventsapplication.presentation.presenter

import com.appsx.eventsapplication.data.repository.exception.ReadAssetFileException
import com.appsx.eventsapplication.domain.useCase.IGetEventDisplayModelsUseCase
import com.appsx.eventsapplication.presentation.view.IEventsListView

class EventsListPresenter(
    private val view: IEventsListView,
    private val getActiveEventDisplayModelsUseCase: IGetEventDisplayModelsUseCase
) : IEventsListPresenter {

    override fun onCreate() {
        try {
            val activeEvents = getActiveEventDisplayModelsUseCase.execute()

            if (activeEvents.isNotEmpty()) {
                view.showEvents(activeEvents)
            }
        } catch (e: ReadAssetFileException) {
            view.showReadErrorMessage()
        }
    }
}