package com.bunbeauty.food_delivery.repository

import com.bunbeauty.food_delivery.model.local.City
import org.springframework.data.repository.CrudRepository

interface CityRepository : CrudRepository<City, String> {
    fun getAllBy(): List<City>
    fun getByUuid(uuid: String): City?
}