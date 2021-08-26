package com.bunbeauty.food_delivery.service

import com.bunbeauty.food_delivery.model.Delivery
import com.bunbeauty.food_delivery.repository.DeliveryRepository
import com.bunbeauty.food_delivery.repository.MenuProductRepository
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
