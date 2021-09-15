package com.bunbeauty.food_delivery.repository

import com.bunbeauty.food_delivery.model.local.MenuProduct
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MenuProductRepository: CrudRepository<MenuProduct, String> {
    fun getAllBy(): List<MenuProduct>
}
