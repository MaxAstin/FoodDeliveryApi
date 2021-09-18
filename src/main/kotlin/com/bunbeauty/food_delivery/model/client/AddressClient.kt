package com.bunbeauty.food_delivery.model.client

import com.bunbeauty.food_delivery.model.local.Profile
import com.bunbeauty.food_delivery.model.local.Street
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*
import kotlin.jvm.Transient

data class AddressClient(
    var uuid: String,

    var street: StreetClient?,
    val streetUuid: String,

    val house: String,
    val flat: String?,
    val entrance: String?,
    val comment: String?,
    val floor: String?,

    @JsonIgnore
    var profile: Profile?,
    val profileUuid: String,
)