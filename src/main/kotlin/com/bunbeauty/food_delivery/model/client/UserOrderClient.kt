package com.bunbeauty.food_delivery.model.client

import com.bunbeauty.food_delivery.enums.OrderStatus
import com.bunbeauty.food_delivery.model.local.Cafe
import com.bunbeauty.food_delivery.model.local.OrderProduct
import com.bunbeauty.food_delivery.model.local.Profile
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*
import kotlin.jvm.Transient

data class UserOrderClient(
    var uuid: String,

    val time: Long,
    val orderStatus: OrderStatus,
    val isDelivery: Boolean,
    val code: String,
    val comment: String?,
    val deferredTime: Long?,
    val bonus: Int?,

    var address: String,
    val addressUuid: String?,

    @JsonIgnore
    var profile: Profile?,
    val profileUuid: String,

    //relation
    @JsonIgnore
    var cafe: Cafe?,
    val cafeUuid: String?,

    var orderProducts: List<OrderProduct>?,
)
