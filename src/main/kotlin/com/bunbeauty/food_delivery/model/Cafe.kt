package com.bunbeauty.food_delivery.model

import javax.persistence.Entity
import javax.persistence.Id


/**
 * Company information
 */
@Entity
data class Cafe(
    @Id
    var uuid: String,
    val fromTime: String,
    val toTime: String,
    val phone: String,
    val latitude: Double,
    val longitude: Double,
    val visible: Boolean
)