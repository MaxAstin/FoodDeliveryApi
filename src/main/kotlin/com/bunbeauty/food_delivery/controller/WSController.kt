package com.bunbeauty.food_delivery.controller

import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import kotlin.concurrent.thread

@Controller
class WSController {

    init {
        thread {
            while (true) {
                Thread.sleep(5000)
                getOrder("order")
            }
        }.start()
    }

    @SendTo("/topic/order")
    fun getOrder(order: String): String {

        println("ws $order")

        return order + System.nanoTime()
    }
}