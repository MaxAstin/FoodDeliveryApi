package com.bunbeauty.food_delivery.service

import com.bunbeauty.food_delivery.model.MenuProduct
import com.bunbeauty.food_delivery.repository.MenuProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MenuProductService {

    @Autowired
    lateinit var menuProductRepository: MenuProductRepository

    fun getMenuProducts(): List<MenuProduct> = menuProductRepository.getAllBy()

       /* MenuProduct(
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
        ),
        MenuProduct(
        uuid = "uuid2",
        name = "BURGER",
        cost = 10,
        discountCost = 10,
        weight = 10,
        description = "description",
        comboDescription = "comboDescription",
        photoLink = "photoLink",
        productCode = "productCode",
        barcode = 1,
        visible = true,
        )*/
//
}