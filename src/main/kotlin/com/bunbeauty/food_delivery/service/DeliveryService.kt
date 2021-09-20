package com.bunbeauty.food_delivery.service

import com.bunbeauty.food_delivery.model.local.Delivery
import com.bunbeauty.food_delivery.repository.DeliveryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class DeliveryService {

    @Autowired
    lateinit var deliveryRepository: DeliveryRepository

    fun insert(delivery: Delivery): Delivery {

        if (delivery.uuid.isEmpty())
            delivery.uuid = UUID.randomUUID().toString()

        deliveryRepository.save(delivery)

        return delivery
    }

    fun getDelivery(): Delivery {
        return deliveryRepository.getAllBy().first()
    }
}
