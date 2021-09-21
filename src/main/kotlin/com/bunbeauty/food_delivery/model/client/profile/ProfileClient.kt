package com.bunbeauty.food_delivery.model.client.profile

import com.bunbeauty.food_delivery.model.client.address.AddressClient
import com.bunbeauty.food_delivery.model.client.user_order.UserOrderClient

data class ProfileClient(
    var uuid: String,
    val phone: String,
    val email: String,
    val addressList: List<AddressClient>?,
    val userOrderList: List<UserOrderClient>?
)
