package com.bunbeauty.food_delivery.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany


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

    val visible: Boolean,

    @OneToMany(mappedBy = "cafe")
    val districts: List<District>,

    val address: String,
)