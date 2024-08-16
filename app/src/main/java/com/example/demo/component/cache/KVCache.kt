package com.example.demo.component.cache

import android.content.Context
import android.os.Parcelable
import com.tencent.mmkv.MMKV
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


object KVCache {

    fun init(context: Context) {
        MMKV.initialize(context.applicationContext)
    }

    fun remove(key: String) {
        MMKV.defaultMMKV().removeValueForKey(key)
    }
}

@Suppress("UNCHECKED_CAST", "IMPLICIT_CAST_TO_ANY")
class KVCacheExt<T>(val key: String, val value: T, val valueRawType: Class<T>) :
    ReadWriteProperty<Any?, T> {

    private val mmkv by lazy {
        MMKV.defaultMMKV()
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return findValue(findKey(property))
    }

    private fun findKey(property: KProperty<*>) = if (key.isEmpty()) property.name else key

    @Suppress("IMPLICIT_CAST_TO_ANY")
    private fun findValue(key: String): T {
        return when (value) {
            is Long -> mmkv.decodeLong(key)
            is Int -> mmkv.decodeInt(key)
            is Boolean -> mmkv.decodeBool(key)
            is Double -> mmkv.decodeDouble(key)
            is String -> mmkv.decodeString(key)
            is Float -> mmkv.decodeFloat(key)
            is Parcelable -> {
                mmkv.decodeParcelable(key, valueRawType as Class<Parcelable>?)
            }
            else -> throw IllegalArgumentException("Unsupported type.")
        } as T
    }


    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        putValue(findKey(property), value)
    }

    private fun putValue(key: String, value: T) {
        when (value) {
            is Long -> mmkv.encode(key, value)
            is Int -> mmkv.encode(key, value)
            is Boolean -> mmkv.encode(key, value)
            is Double -> mmkv.encode(key, value)
            is String -> mmkv.encode(key, value)
            is Float -> mmkv.encode(key, value)
            is Parcelable -> mmkv.decodeParcelable(key, valueRawType as Class<Parcelable>?)
            else -> throw IllegalArgumentException("Unsupported type.")
        } as T
    }
}

class KVCacheParcelableExt<T : Parcelable?>(val key: String, val valueRawType: Class<T>) :
    ReadWriteProperty<Any?, T?> {

    private val mmkv by lazy {
        MMKV.defaultMMKV()
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T? = mmkv.decodeParcelable(findKey(property), valueRawType) ?: null as T?

    private fun findKey(property: KProperty<*>) = key.ifEmpty { property.name }


    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T?) {
        value?.let {
            putValue(findKey(property), it)
        }
    }

    private fun putValue(key: String, value: T) {
        mmkv.encode(key, value)
    }

}