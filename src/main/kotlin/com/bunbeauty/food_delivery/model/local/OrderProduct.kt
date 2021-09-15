package com.bunbeauty.food_delivery.model.local

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class OrderProduct(

    @Id
    val uuid: String,

    @Embedded
    val menuProduct: MenuProduct,

    var count: Int,

    @ManyToOne
    @JoinColumn(name = "user_order_uuid")
    @JsonIgnore
    var userOrder: UserOrder?
)