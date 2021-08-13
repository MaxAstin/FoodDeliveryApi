package com.bunbeauty.food_delivery.model

import javax.persistence.*

@Entity
data class District(
    @Id
    var uuid: String,

    var name: String,

    @OneToMany(mappedBy = "district")
    val streets: List<Street> = emptyList(),

    @ManyToOne
    @JoinColumn(name = "cafe_uuid")
    var cafe: Cafe? = null
)