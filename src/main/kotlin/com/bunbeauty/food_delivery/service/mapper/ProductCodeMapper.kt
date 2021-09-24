package com.bunbeauty.food_delivery.service.mapper

import com.bunbeauty.food_delivery.model.client.ProductCodeClient
import com.bunbeauty.food_delivery.model.local.ProductCode
import org.springframework.stereotype.Service

@Service
class ProductCodeMapper {

    fun toEntityModel(productCode: ProductCodeClient): ProductCode {
        return ProductCode(
            uuid = productCode.uuid,
            name = productCode.name,
            menuProducts = emptySet()
        )
    }

    fun toClientModel(productCode: ProductCode): ProductCodeClient {
        return ProductCodeClient(
            uuid = productCode.uuid,
            name = productCode.name
        )
    }
}