package com.bunbeauty.food_delivery.repository

import com.bunbeauty.food_delivery.model.local.Street
import org.springframework.data.repository.CrudRepository

interface StreetRepository : CrudRepository<Street, String> {
    fun getByUuid(uuid: String): Street?
}