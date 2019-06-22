package com.appsx.eventsapplication.common.decoratorFunctions

class ErrorLoggableFunction(
    private val origin: IFunction
) : IFunction {

    override fun accept(f: () -> Unit) {
        try {
            origin.accept(f)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}