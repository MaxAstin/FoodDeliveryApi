package com.bunbeauty.food_delivery.service

import com.bunbeauty.food_delivery.model.MenuProduct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MenuProductService {

    /*@Autowired
    lateinit var menuProductRepository: MenuProductRepository*/

    fun getMenuProducts(): List<MenuProduct> = listOf(MenuProduct(
            uuid = "uuid",
            name = "PIZZA",
            cost = 10,
            discountCost = 10,
            weight = 10,
            description = "description",
            comboDescription = "comboDescription",
            photoLink = "photoLink",
            productCode = "productCode",
            barcode = 1,
            visible = true,
    ))//menuProductRepository.getMenuProducts()
}