package com.bunbeauty.food_delivery.config

import com.bunbeauty.food_delivery.model.local.order.UserOrder
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry
import org.springframework.web.socket.handler.TextWebSocketHandler

@Configuration
@EnableWebSocket
class WebSocketConfig : WebSocketConfigurer {

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(OrderHandler(), "/order")
            .setAllowedOrigins("*")
    }
}

class OrderHandler : TextWebSocketHandler() {

    private val sessionMap: MutableMap<String, WebSocketSession> = HashMap()

    override fun afterConnectionEstablished(session: WebSocketSession) {
        super.afterConnectionEstablished(session)

        val profileUuid = session.attributes["profileUuid"].toString()
        sessionMap[profileUuid] = session
    }

    fun sendUpdatedOrder(order: UserOrder) {
        sessionMap[order.profile.uuid]?.sendMessage(TextMessage(order.toString()))
    }
}