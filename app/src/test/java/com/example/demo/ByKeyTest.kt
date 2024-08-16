package com.example.demo

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class ByKeyTest {



}

class TrimDelegate<T>() : ReadWriteProperty<Any?, T> {


    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return thisRef as T
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        TODO("Not yet implemented")
    }
}