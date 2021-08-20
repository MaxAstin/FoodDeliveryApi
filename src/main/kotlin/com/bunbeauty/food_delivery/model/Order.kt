package com.bunbeauty.food_delivery.model

import com.bunbeauty.food_delivery.enums.OrderStatus

data class Order(
    val uuid: String,

    val address: Address,
    val comment: String,
    val phone: String,
    val time: Long,
    val orderStatus: OrderStatus,
    val isDelivery: Boolean,
    val code: String,
    val email: String,
    val deferredTime: String,
    val bonus: Int,
    val userId: String,
    val cafeId: String,
    //var cartProducts: List<CartProduct>,
)
