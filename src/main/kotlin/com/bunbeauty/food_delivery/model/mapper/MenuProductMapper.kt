package com.bunbeauty.food_delivery.model.mapper

import com.bunbeauty.food_delivery.model.client.MenuProductClient
import com.bunbeauty.food_delivery.model.client.StreetClient
import com.bunbeauty.food_delivery.model.local.MenuProduct
import com.bunbeauty.food_delivery.model.local.Street
import org.springframework.stereotype.Service

@Service
class MenuProductMapper {

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
            productCode = menuProduct.productCode,
            barcode = menuProduct.barcode,
            visible = menuProduct.visible,
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
            productCode = menuProduct.productCode,
            barcode = menuProduct.barcode,
            visible = menuProduct.visible,
        )
    }

}