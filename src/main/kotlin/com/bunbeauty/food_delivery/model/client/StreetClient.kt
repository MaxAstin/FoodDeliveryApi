package com.bunbeauty.food_delivery.model.client

import com.bunbeauty.food_delivery.model.local.Address
import com.bunbeauty.food_delivery.model.local.Cafe
import com.fasterxml.jackson.annotation.JsonIgnore

data class StreetClient(
    var uuid: String,
    val name: String,

    @JsonIgnore
    var cafe: Cafe?,
    val cafeUuid: String,
    val cityUuid: String,

    @JsonIgnore
    var addressList: List<Address>?
)