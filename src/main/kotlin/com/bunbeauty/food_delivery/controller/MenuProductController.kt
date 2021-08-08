package com.bunbeauty.food_delivery.controller

import com.bunbeauty.food_delivery.service.MenuProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MenuProductController(val menuProductService: MenuProductService) {

    @GetMapping
    fun getMenuProduct() = menuProductService.getMenuProducts()

}