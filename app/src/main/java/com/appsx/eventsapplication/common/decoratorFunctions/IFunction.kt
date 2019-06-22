package com.appsx.eventsapplication.common.decoratorFunctions

interface IFunction {
    fun accept(f: () -> Unit)
}