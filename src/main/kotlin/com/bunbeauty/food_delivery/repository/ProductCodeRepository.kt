package com.bunbeauty.food_delivery.repository

import com.bunbeauty.food_delivery.model.local.ProductCode
import org.springframework.data.repository.CrudRepository

interface ProductCodeRepository : CrudRepository<ProductCode, String> {
    fun getByUuid(uuid: String): ProductCode?
    fun getAllBy(): List<ProductCode>
}