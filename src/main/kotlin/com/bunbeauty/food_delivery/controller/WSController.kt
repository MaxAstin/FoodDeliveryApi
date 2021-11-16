package com.bunbeauty.food_delivery.controller

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class WSController {

    @MessageMapping("/message")
    @SendTo("/topic/messages")
    fun getOrder(input: Input): Output {

        Thread.sleep(3000)

        return Output("ws get " + input.message)
    }

    data class Input(val message: String)
    data class Output(val message: String)
}
