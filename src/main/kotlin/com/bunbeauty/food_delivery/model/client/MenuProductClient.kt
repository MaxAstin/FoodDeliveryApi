package com.bunbeauty.food_delivery.model.client

import com.fasterxml.jackson.annotation.JsonIgnore

data class MenuProductClient(
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
    @JsonIgnore
    val productCodeUuids: Set<String>?,
    var productCodes: Set<ProductCodeClient>?
)