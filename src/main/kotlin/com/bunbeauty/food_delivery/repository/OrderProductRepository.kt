package com.bunbeauty.food_delivery.repository

import com.bunbeauty.food_delivery.model.local.order.OrderCartProduct
import org.springframework.data.repository.CrudRepository

interface OrderProductRepository : CrudRepository<OrderCartProduct, String> {
    fun getAllBy() : List<OrderCartProduct>
    fun getByUuid(uuid:String) : OrderCartProduct?
}