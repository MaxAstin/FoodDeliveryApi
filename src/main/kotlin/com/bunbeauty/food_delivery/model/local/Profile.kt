package com.bunbeauty.food_delivery.model.local

import com.bunbeauty.food_delivery.model.local.order.UserOrder
import javax.persistence.*

@Entity
data class Profile(
    @Id
    var uuid: String,
    val phone: String,
    var email: String,
    @OneToMany(mappedBy = "profile", cascade = [CascadeType.ALL])
    val addressList: List<Address>,

    @OneToMany(mappedBy = "profile", cascade = [CascadeType.ALL])
    val userOrderList: List<UserOrder>
)
