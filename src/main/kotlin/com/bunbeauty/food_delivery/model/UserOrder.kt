package com.bunbeauty.food_delivery.model

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
    val comment: String?,
    val deferredTime: String?,
    val bonus: Int?,

    var address: String,
    @Transient
    val addressUuid: String?,

    @ManyToOne
    @JoinColumn(name = "profile_uuid")
    @JsonIgnoreProperties("userOrderList")
    var profile: Profile?,
    @Transient
    val profileUuid: String,

    //relation
    @ManyToOne
    @JoinColumn(name = "cafe_uuid")
    @JsonIgnore
    var cafe: Cafe?,
    @Transient
    val cafeUuid: String?,

    //@OneToMany(mappedBy = "order")
    //var cartProducts: List<CartProduct>,

)
