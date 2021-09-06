package com.bunbeauty.food_delivery.repository

import com.bunbeauty.food_delivery.model.Cafe
import org.springframework.data.repository.CrudRepository

interface CafeRepository : CrudRepository<Cafe, String> {
    fun getAllBy(): List<Cafe>

    fun getAllByCity(city: String): List<Cafe>
}