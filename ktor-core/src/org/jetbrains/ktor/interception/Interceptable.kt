package org.jetbrains.ktor.interception

public class Interceptable0<TResult>(val function: () -> TResult) {
    private val interceptors = arrayListOf<(() -> TResult) -> TResult>()

    public fun intercept(handler: (next: () -> TResult) -> TResult) {
        interceptors.add(handler)
    }

    fun invokeAt(index: Int): TResult = when {
        index < interceptors.size() -> interceptors[index]({ invokeAt(index + 1) })
        else -> function()
    }

    public fun call(): TResult = invokeAt(0)
}

public class Interceptable1<TParam0, TResult>(val function: (TParam0) -> TResult) {
    private val interceptors = arrayListOf<(TParam0, (TParam0) -> TResult) -> TResult>()

    public fun intercept(handler: (param: TParam0, next: (TParam0) -> TResult) -> TResult) {
        interceptors.add(handler)
    }

    fun invokeAt(param: TParam0, index: Int): TResult = when {
        index < interceptors.size() -> interceptors[index](param, { param -> invokeAt(param, index + 1) })
        else -> function(param)
    }

    public fun call(param: TParam0): TResult = invokeAt(param, 0)
}

public class Interceptable2<TParam0, TParam1, TResult>(val function: (TParam0, TParam1) -> TResult) {
    private val interceptors = arrayListOf<(TParam0, TParam1, (TParam0, TParam1) -> TResult) -> TResult>()

    public fun intercept(handler: (TParam0, TParam1, (TParam0, TParam1) -> TResult) -> TResult) {
        interceptors.add(handler)
    }

    fun invokeAt(param1: TParam0, param2: TParam1, index: Int): TResult = when {
        index < interceptors.size() -> interceptors[index](param1, param2, { param1, param2 -> invokeAt(param1, param2, index + 1) })
        else -> function(param1, param2)
    }

    public fun call(param1: TParam0, param2: TParam1): TResult = invokeAt(param1, param2, 0)
}