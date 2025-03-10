package org.jetbrains.ktor.application

import java.util.concurrent.*

public open class AttributeKey<T>

public class Attributes {
    private val map by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        ConcurrentHashMap<AttributeKey<*>, Any?>()
    }

    suppress("UNCHECKED_CAST")
    public fun <T> get(key: AttributeKey<T>): T = map[key] as T

    public fun <T> put(key: AttributeKey<T>, value: T) {
        map[key] = value
    }

    suppress("UNCHECKED_CAST")
    public fun <T> computeIfAbsent(key: AttributeKey<T>, block: () -> T): T = map.computeIfAbsent(key) { block() } as T

    public val allKeys: List<AttributeKey<*>>
        get() = map.keySet().toList()
}
