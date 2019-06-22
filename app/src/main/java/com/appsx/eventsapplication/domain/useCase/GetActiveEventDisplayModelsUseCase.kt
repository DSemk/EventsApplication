package com.appsx.eventsapplication.domain.useCase

import com.appsx.eventsapplication.data.model.IEventData
import com.appsx.eventsapplication.data.repository.IEventsRepository
import com.appsx.eventsapplication.presentation.model.EventDisplayModel
import com.appsx.eventsapplication.presentation.model.IEventDisplayModel

class GetActiveEventDisplayModelsUseCase(
    private val eventsRepository: IEventsRepository
) : IGetEventDisplayModelsUseCase {

    override fun execute(): List<IEventDisplayModel> {
        val events = eventsRepository.load()
        val activeEventDisplayModels: MutableList<IEventDisplayModel> = mutableListOf()

        for (event: IEventData in events) {
            if (event.isActive()) {
                activeEventDisplayModels.add(EventDisplayModel(event.getName()))
            }
        }

        return activeEventDisplayModels
    }
}