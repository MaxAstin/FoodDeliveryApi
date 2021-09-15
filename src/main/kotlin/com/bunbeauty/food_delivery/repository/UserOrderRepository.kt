package com.bunbeauty.food_delivery.repository

import com.bunbeauty.food_delivery.model.local.UserOrder
import org.springframework.data.repository.CrudRepository

interface UserOrderRepository : CrudRepository<UserOrder, String> {
    fun findByProfileUuid(profileUuid: String) : List<UserOrder>
}