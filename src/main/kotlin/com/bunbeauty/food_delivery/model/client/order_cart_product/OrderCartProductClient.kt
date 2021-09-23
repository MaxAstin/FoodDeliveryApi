package com.bunbeauty.food_delivery.model.client.order_cart_product

import com.bunbeauty.food_delivery.model.client.order_menu_product.OrderMenuProductClient

data class OrderCartProductClient(
    val uuid: String,

    val menuProduct: OrderMenuProductClient,
    var count: Int
)