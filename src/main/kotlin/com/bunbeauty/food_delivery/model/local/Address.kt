package com.bunbeauty.food_delivery.model.local

import javax.persistence.*

@Entity
data class Address(
    @Id
    var uuid: String,

    @ManyToOne
    @JoinColumn(name = "street_uuid")
    var street: Street,

    val house: String,
    val flat: String?,
    val entrance: String?,
    val comment: String?,
    val floor: String?,

    @ManyToOne
    @JoinColumn(name = "profile_uuid")
    var profile: Profile,
)