package com.bunbeauty.food_delivery.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.config.annotation.*
import org.springframework.web.socket.handler.TextWebSocketHandler
import kotlin.concurrent.thread

@Configuration
@EnableWebSocket
class WebSocketConfig : WebSocketConfigurer {

//    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
//        registry.addEndpoint("/our-websoket").withSockJS()
//    }
//
//    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
//        registry.enableSimpleBroker("/topic")
//        registry.setApplicationDestinationPrefixes("/ws")
//    }

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        println("registerWebSocketHandlers")
        registry.addHandler(OrderHandler(), "/chat")
            .setAllowedOrigins("*")
            .setHandshakeHandler { request, response, wsHandler, attributes ->
                println("request $request \nresponse $response \nwsHandler $wsHandler \nattributes $attributes")
                true
            }
            .withSockJS()
    }
}

class OrderHandler: TextWebSocketHandler() {

    override fun handleMessage(session: WebSocketSession, message: WebSocketMessage<*>) {

        //Thread.sleep(5000)

        thread {
            Thread.sleep(5000)
            session.sendMessage(TextMessage("order " + System.nanoTime()))
        }.start()


    }
}