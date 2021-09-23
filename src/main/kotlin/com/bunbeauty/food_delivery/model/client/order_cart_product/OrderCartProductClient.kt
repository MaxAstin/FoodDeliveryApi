package com.bunbeauty.food_delivery.model.client.order_cart_product

data class OrderCartProductClient(
    val uuid: String,

    val name: String,
    val cost: Int,
    val discountCost: Int?,
    val weight: Int?,
    val description: String,
    val comboDescription: String?,
    val barcode: Int?,
    val photoLink: String?,
    val orderUuid: String,
    var count: Int
)