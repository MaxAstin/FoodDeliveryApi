package com.bunbeauty.food_delivery.model.local.order

import javax.persistence.*

@Entity
data class OrderCartProduct(

    @Id
    val uuid: String,

    @Embedded
    var orderMenuProduct: OrderMenuProduct,

    var count: Int,

    @ManyToOne
    @JoinColumn(name = "user_order_uuid")
    var userOrder: UserOrder?
)