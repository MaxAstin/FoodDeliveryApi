package com.bunbeauty.food_delivery.model.local

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Delivery(
    @Id
    var uuid: String,
    val cost: Int,
    val forFree: Int
)
