package com.bunbeauty.food_delivery.model.mapper

import com.bunbeauty.food_delivery.model.client.menu_product.MenuProductClient
import com.bunbeauty.food_delivery.model.client.menu_product.PostMenuProductClient
import com.bunbeauty.food_delivery.model.local.MenuProduct
import com.bunbeauty.food_delivery.model.local.order.OrderMenuProduct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MenuProductMapper {

    @Autowired
    lateinit var productCodeMapper: ProductCodeMapper

    fun toEntityModel(menuProduct: PostMenuProductClient): MenuProduct {
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
            productCodes = menuProduct.productCodes.map { productCodeMapper.toClientModel(it) }.toSet()
        )
    }

    fun toOrderMenuProductEntity(menuProduct: MenuProduct): OrderMenuProduct {
        return OrderMenuProduct(
            name = menuProduct.name,
            cost = menuProduct.cost,
            discountCost = menuProduct.discountCost,
            weight = menuProduct.weight,
            description = menuProduct.description,
            comboDescription = menuProduct.comboDescription,
            barcode = menuProduct.barcode,
            photoLink = menuProduct.photoLink,
        )
    }
}