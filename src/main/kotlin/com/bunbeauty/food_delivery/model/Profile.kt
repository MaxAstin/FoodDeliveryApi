package com.bunbeauty.food_delivery.model

import javax.persistence.*

@Entity
data class Profile(
    @Id
    var uuid: String,
    val phone: String,
    val email: String,
    @OneToMany(mappedBy = "profile")
    val addressList: List<Address>?
)
