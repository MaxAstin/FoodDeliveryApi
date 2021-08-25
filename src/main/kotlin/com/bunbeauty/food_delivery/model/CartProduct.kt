package com.bunbeauty.food_delivery.model

import javax.persistence.*

@Entity
data class CartProduct(

    @Id
    val uuid: String,

    @Embedded
    val menuProduct: MenuProduct,

    var count: Int,

    @ManyToOne
    @JoinColumn(name = "order_uuid")
    var order: Order? =  null
)