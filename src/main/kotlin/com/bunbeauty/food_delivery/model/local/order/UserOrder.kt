package com.bunbeauty.food_delivery.model.local.order

import com.bunbeauty.food_delivery.enums.OrderStatus
import com.bunbeauty.food_delivery.model.local.Cafe
import com.bunbeauty.food_delivery.model.local.Profile
import javax.persistence.*

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
    val deferredTime: Long?,
    val bonus: Int?,

    @ManyToOne
    @JoinColumn(name = "profile_uuid")
    var profile: Profile,

    @ManyToOne
    @JoinColumn(name = "cafe_uuid")
    var cafe: Cafe,

    @OneToMany(mappedBy = "userOrder", cascade = [CascadeType.ALL])
    var orderCartProducts: List<OrderCartProduct>,
)
