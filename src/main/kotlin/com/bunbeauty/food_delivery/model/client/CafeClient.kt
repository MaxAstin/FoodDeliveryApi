package com.bunbeauty.food_delivery.model.client

import com.fasterxml.jackson.annotation.JsonIgnore

data class CafeClient(
    var uuid: String,
    val fromTime: String,
    val toTime: String,
    val phone: String,
    val latitude: Double,
    val longitude: Double,
    val visible: Boolean,

    @JsonIgnore
    var city: CityClient?,
    val cityUuid: String,

    val address: String,
)