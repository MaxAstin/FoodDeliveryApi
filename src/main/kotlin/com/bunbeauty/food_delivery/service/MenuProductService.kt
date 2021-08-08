package com.bunbeauty.food_delivery.service

import com.bunbeauty.food_delivery.model.MenuProduct
import com.bunbeauty.food_delivery.repository.MenuProductRepository
import org.springframework.stereotype.Service

@Service
class MenuProductService(val menuProductRepository: MenuProductRepository) {

    fun getMenuProducts(): List<MenuProduct> = menuProductRepository.getMenuProducts()
}