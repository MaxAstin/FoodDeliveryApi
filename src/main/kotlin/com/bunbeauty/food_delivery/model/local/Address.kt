package com.bunbeauty.food_delivery.model.local

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*
import kotlin.jvm.Transient

@Entity
data class Address(
    @Id
    var uuid: String,

    @ManyToOne
    @JoinColumn(name = "street_uuid")
    @JsonIgnore
    var street: Street?,
    @Transient
    val streetUuid: String,

    val house: String,
    val flat: String?,
    val entrance: String?,
    val comment: String?,
    val floor: String?,

    @ManyToOne
    @JoinColumn(name = "profile_uuid")
    @JsonIgnore
    var profile: Profile?,
    @Transient
    val profileUuid: String,
)