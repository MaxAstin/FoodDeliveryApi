package com.bunbeauty.food_delivery.model.client

data class CafeClient(
    var uuid: String,
    val fromTime: String,
    val toTime: String,
    val phone: String,
    val latitude: Double,
    val longitude: Double,
    val visible: Boolean,
    val cityUuid: String,
    val address: String,
)