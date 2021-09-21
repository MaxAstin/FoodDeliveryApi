package com.bunbeauty.food_delivery.model.client.street

data class StreetClient(
    var uuid: String,
    val name: String,

    val cafeUuid: String,
    val cityUuid: String,
)