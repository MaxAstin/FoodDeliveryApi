package com.bunbeauty.food_delivery.model

import com.bunbeauty.food_delivery.enums.OrderStatus
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class Order(
    @Id
    val uuid: String,
    @Embedded
    val address: Address,
    val comment: String,
    val phone: String,
    val time: Long,
    val orderStatus: OrderStatus,
    val isDelivery: Boolean,
    val code: String,
    val email: String,
    val deferredTime: String,
    val bonus: Int,
    //relation
    val userId: String,
    val cafeId: String,

    @OneToMany(mappedBy = "order")
    var cartProducts: List<CartProduct>,
)
