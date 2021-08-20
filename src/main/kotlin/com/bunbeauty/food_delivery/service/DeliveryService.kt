package com.bunbeauty.food_delivery.service

import com.bunbeauty.food_delivery.model.Delivery
import org.springframework.stereotype.Service

@Service
class DeliveryService {
    fun getDelivery(): Delivery {
        return Delivery(cost = 100, forFree = 500)
    }
}
