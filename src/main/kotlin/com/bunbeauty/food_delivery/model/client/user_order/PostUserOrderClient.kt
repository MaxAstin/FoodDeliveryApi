package com.bunbeauty.food_delivery.model.client.user_order

import com.bunbeauty.food_delivery.enums.OrderStatus
import com.bunbeauty.food_delivery.model.client.order_cart_product.PostOrderCartProductClient

data class PostUserOrderClient(
    var uuid: String,

    val orderStatus: OrderStatus,
    val isDelivery: Boolean,
    val code: String,
    val comment: String?,
    val deferredTime: Long?,
    val bonus: Int?,

    var address: String,
    val addressUuid: String?,

    val profileUuid: String,
    val cafeUuid: String?,

    var orderProducts: List<PostOrderCartProductClient>?,
)
