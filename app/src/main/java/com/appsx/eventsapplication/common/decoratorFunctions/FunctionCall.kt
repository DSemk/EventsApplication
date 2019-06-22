package com.appsx.eventsapplication.common.decoratorFunctions

class FunctionCall : IFunction {
    override fun accept(f: () -> Unit) {
        f.invoke()
    }
}