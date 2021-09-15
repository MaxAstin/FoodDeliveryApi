package com.bunbeauty.food_delivery.service

import com.bunbeauty.food_delivery.model.local.Delivery
import com.bunbeauty.food_delivery.repository.DeliveryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DeliveryService {
    @Autowired
    lateinit var deliveryRepository: DeliveryRepository

    fun getDelivery(): Delivery {
        return deliveryRepository.getAllBy().first()
    }
}
