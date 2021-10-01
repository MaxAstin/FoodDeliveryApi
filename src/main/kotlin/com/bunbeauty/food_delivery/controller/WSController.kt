package com.bunbeauty.food_delivery.controller

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class WSController {

    @MessageMapping("/order")
    @SendTo("/topic/orders")
    fun getOrder(code: String): String {

        Thread.sleep(2000)
        println("getOrder")

        return code
    }
}