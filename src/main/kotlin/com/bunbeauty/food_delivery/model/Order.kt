package com.bunbeauty.food_delivery.model

import com.bunbeauty.food_delivery.enums.OrderStatus

data class Order(
    var uuid: String,

    //var address: Address = Address(),
    var comment: String,
    var phone: String,
    var time: Long,
    var orderStatus: OrderStatus,
    var isDelivery: Boolean,
    var code: String,
    var email: String,
    var deferredTime: String,
    var bonus: Int,
    var userId: String,
    var cafeId: String,
    //var cartProducts: List<CartProduct>,
)
