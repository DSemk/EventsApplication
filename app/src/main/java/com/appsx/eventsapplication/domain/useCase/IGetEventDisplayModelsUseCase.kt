package com.appsx.eventsapplication.domain.useCase

import com.appsx.eventsapplication.presentation.model.IEventDisplayModel

interface IGetEventDisplayModelsUseCase {
    fun execute(): List<IEventDisplayModel>
}