package com.bunbeauty.food_delivery.model.local

import javax.persistence.*

@Entity
data class Street(
    @Id
    val uuid: String,

    val name: String,

    @ManyToOne
    @JoinColumn(name="cafe_uuid")
    val cafe: Cafe,

    @OneToMany(mappedBy = "street", cascade = [CascadeType.ALL])
    val addressList: List<Address>
)