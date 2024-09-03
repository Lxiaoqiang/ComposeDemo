package com.example.demo

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)

        println(646.4 / 60)
        println(646.4 % 60)
    }

    @Test
    fun testFlow() {

        val flowA = MutableStateFlow(1)
        val flowB = MutableStateFlow(2)
        val flowC = flowA.combine(flowB){ a, b -> a + b}
        GlobalScope.launch {
            flowC.collect {
                println("result: $it")
            }
        }

        GlobalScope.launch {
            delay(2000)
            flowA.emit(2)
            flowB.emit(3)
        }
        Thread.sleep(5000)
    }

    @Test
    fun `flow merge`() {

    }

    private fun loadMore() = callbackFlow {
        trySend("")
        awaitClose()
    }


    @Test
    fun `for inline`(){
        foo {

        }
    }

    inline fun foo(fx:() -> Unit) {

    }
}