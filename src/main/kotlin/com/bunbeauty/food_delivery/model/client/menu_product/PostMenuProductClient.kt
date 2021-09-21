package com.bunbeauty.food_delivery.model.client.menu_product

import com.bunbeauty.food_delivery.model.client.ProductCodeClient


data class PostMenuProductClient(
    var uuid: String,
    val name: String,
    val cost: Int,
    val discountCost: Int?,
    val weight: Int?,
    val description: String,
    val comboDescription: String?,
    val photoLink: String?,
    val barcode: Int?,
    val visible: Boolean,
    val productCodeUuids: Set<String>?,
    var productCodes: Set<ProductCodeClient>?
)