package com.bunbeauty.food_delivery.model.client.order_cart_product


data class PostOrderCartProductClient(
    val uuid: String?,

    val menuProductUuid: String,
    var count: Int,
)