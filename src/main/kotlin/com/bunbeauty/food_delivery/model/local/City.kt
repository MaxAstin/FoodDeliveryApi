package com.bunbeauty.food_delivery.model.local

import javax.persistence.*

@Entity
data class City(
    @Id
    var uuid: String,

    val name: String,

    @OneToMany(mappedBy = "city", cascade = [CascadeType.ALL])
    val cafeList : List<Cafe>,
)