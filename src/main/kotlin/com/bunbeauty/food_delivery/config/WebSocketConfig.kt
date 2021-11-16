package com.bunbeauty.food_delivery.config

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.config.annotation.*
import org.springframework.web.socket.handler.TextWebSocketHandler

@Configuration
@EnableWebSocketMessageBroker
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
        registry.addHandler(OrderHandler(), "/order").withSockJS()
    }

    class OrderHandler(): TextWebSocketHandler() {

        override fun handleMessage(session: WebSocketSession, message: WebSocketMessage<*>) {

            Thread.sleep(5000)
            session.sendMessage(TextMessage("order " + System.nanoTime()))
        }
    }
}