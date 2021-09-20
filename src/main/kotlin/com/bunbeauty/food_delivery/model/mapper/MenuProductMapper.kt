package com.bunbeauty.food_delivery.model.mapper

import com.bunbeauty.food_delivery.model.client.MenuProductClient
import com.bunbeauty.food_delivery.model.client.StreetClient
import com.bunbeauty.food_delivery.model.local.MenuProduct
import com.bunbeauty.food_delivery.model.local.ProductCode
import com.bunbeauty.food_delivery.model.local.Street
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MenuProductMapper {

    @Autowired
    lateinit var productCodeMapper: ProductCodeMapper

    fun toEntityModel(menuProduct: MenuProductClient): MenuProduct {
        return MenuProduct(
            uuid = menuProduct.uuid,
            name = menuProduct.name,
            cost = menuProduct.cost,
            discountCost = menuProduct.discountCost,
            weight = menuProduct.weight,
            description = menuProduct.description,
            comboDescription = menuProduct.comboDescription,
            photoLink = menuProduct.photoLink,
            barcode = menuProduct.barcode,
            visible = menuProduct.visible,
            productCodes = menuProduct.productCodes?.map { productCodeMapper.toEntityModel(it) }?.toSet() ?: emptySet()
        )
    }

    fun toClientModel(menuProduct: MenuProduct): MenuProductClient {
        return MenuProductClient(
            uuid = menuProduct.uuid,
            name = menuProduct.name,
            cost = menuProduct.cost,
            discountCost = menuProduct.discountCost,
            weight = menuProduct.weight,
            description = menuProduct.description,
            comboDescription = menuProduct.comboDescription,
            photoLink = menuProduct.photoLink,
            barcode = menuProduct.barcode,
            visible = menuProduct.visible,
            productCodeUuids = menuProduct.productCodes.map { it.uuid }.toSet(),
            productCodes = menuProduct.productCodes.map { productCodeMapper.toClientModel(it) }.toSet()
        )
    }

}