package com.bunbeauty.food_delivery.repository

import com.bunbeauty.food_delivery.model.local.Delivery
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DeliveryRepository: CrudRepository<Delivery, String> {
    fun getAllBy(): List<Delivery>
}