package com.bunbeauty.food_delivery.model.local

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
data class ProductCode(
    @Id
    val uuid: String,
    val name: String,

    @ManyToMany
    val menuProducts: Set<MenuProduct>
)