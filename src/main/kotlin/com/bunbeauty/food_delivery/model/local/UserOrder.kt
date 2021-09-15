package com.bunbeauty.food_delivery.model.local

import com.bunbeauty.food_delivery.enums.OrderStatus
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*
import kotlin.jvm.Transient

@Entity
data class UserOrder(
    @Id
    var uuid: String,
    val time: Long,
    val orderStatus: OrderStatus,
    val isDelivery: Boolean,
    val code: String,
    val address: String,

    val comment: String?,
    val deferredTime: String?,
    val bonus: Int?,

    @ManyToOne
    @JoinColumn(name = "profile_uuid")
    //@JsonIgnoreProperties("userOrderList")
    var profile: Profile,

    //relation
    @ManyToOne
    @JoinColumn(name = "cafe_uuid")
    var cafe: Cafe,

    @OneToMany(mappedBy = "userOrder", cascade = [CascadeType.ALL])
    var orderProducts: List<OrderProduct>,
)
