package com.appsx.eventsapplication.common.decoratorFunctions

import android.content.Context
import android.widget.Toast


class SafeFunction(
    private val origin: IFunction,
    private val context: Context
) : IFunction {
    override fun accept(f: () -> Unit) {
        try {
            origin.accept(f)
        } catch (e: Throwable) {
            try {
                showToast(e.cause!!.message!!)
            } catch (exception: KotlinNullPointerException) {
                showToast(e.toString())
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}