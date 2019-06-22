package com.appsx.eventsapplication.common

import android.content.Context
import com.appsx.eventsapplication.common.decoratorFunctions.*
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Proxy
import java.util.concurrent.Executors

fun buildPresenterFunctionCallStack(context: Context): IFunction {
    return AsyncFunction(
        SafeFunction(
            ErrorLoggableFunction(
                FunctionCall()
            ),
            context
        ),
        Executors.newCachedThreadPool()
    )
}

fun buildViewFunctionCallStack(context: Context): IFunction {
    return InMainThreadFunction(
        SafeFunction(
            ErrorLoggableFunction(
                FunctionCall()
            ),
            context
        )
    )
}

fun <T : Any> wrapToProxy(any: T, f: IFunction): T {
    return wrapToProxy(any, FunctionProxyInvocationHandler(any, f))
}

fun <T : Any> wrapToProxy(any: T, handler: InvocationHandler): T {
    return Proxy.newProxyInstance(
        any::class.java.classLoader,
        any::class.java.interfaces,
        handler
    ) as T
}
