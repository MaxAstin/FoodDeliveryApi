package com.bunbeauty.food_delivery.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
data class Street(
    @Id
    var uuid: String,

    var name: String,

    @ManyToOne
    @JoinColumn(name="district_uuid")
    var district: District?
)