package com.bunbeauty.food_delivery.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

//user address
@Entity
data class Address(
    @Id
    val uuid: String,

    @ManyToOne
    @JoinColumn(name = "street_uuid")
    val street: Street?,

    val house: String,
    val flat: String,
    val entrance: String,
    val comment: String,
    val floor: String,
    //relation
    val userUuid: String?,
    val orderUuid: String?
)