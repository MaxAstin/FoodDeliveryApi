package com.bunbeauty.food_delivery.model.client.address

import com.bunbeauty.food_delivery.model.client.street.PostStreetClient

data class PostAddressClient(
    var uuid: String,

    var street: PostStreetClient?,
    val streetUuid: String,

    val house: String,
    val flat: String?,
    val entrance: String?,
    val comment: String?,
    val floor: String?,

    val profileUuid: String
)