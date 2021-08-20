package com.bunbeauty.food_delivery.model

import javax.persistence.*

@Entity
data class Street(
    @Id
    val uuid: String,

    val name: String,

    @ManyToOne
    @JoinColumn(name="district_uuid")
    val district: District?,

    @OneToMany(mappedBy = "street")
    val address: List<Address>
)