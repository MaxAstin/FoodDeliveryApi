package com.bunbeauty.food_delivery.model.local.order

import javax.persistence.*

@Embeddable
class OrderMenuProduct(
    var name: String,
    var cost: Int,
    var discountCost: Int?,
    var weight: Int?,
    var description: String,
    var comboDescription: String?,
    var barcode: Int?,
    var photoLink: String?
)