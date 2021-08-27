package com.bunbeauty.food_delivery.model

import com.fasterxml.jackson.annotation.JsonIgnore
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
    @JsonIgnore
    var cafe: Cafe
)