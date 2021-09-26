package com.bunbeauty.food_delivery.controller

import com.bunbeauty.food_delivery.model.client.user_order.UserOrderClient
import com.bunbeauty.food_delivery.repository.UserOrderRepository
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class WSController {

    @MessageMapping("/order")
    @SendTo("/topic/orders")
    fun getOrder(orderClient: UserOrderClient): String {

        Thread.sleep(2000)
        println("getOrder")

        return orderClient.code
    }
}