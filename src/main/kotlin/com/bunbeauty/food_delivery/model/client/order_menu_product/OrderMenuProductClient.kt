package com.bunbeauty.food_delivery.model.client.order_menu_product

class OrderMenuProductClient(
    val name: String,
    val cost: Int,
    val discountCost: Int?,
    val weight: Int?,
    val description: String,
    val comboDescription: String?,
    val barcode: Int?,
)