package com.bunbeauty.food_delivery.model.client.user_order

import com.bunbeauty.food_delivery.enums.OrderStatus
import com.bunbeauty.food_delivery.model.client.order_cart_product.PostOrderCartProductClient

data class PatchUserOrderClient(
    val orderStatus: OrderStatus?,
)
