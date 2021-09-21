package com.bunbeauty.food_delivery.model.client.profile

import com.bunbeauty.food_delivery.model.client.AddressClient
import com.bunbeauty.food_delivery.model.client.UserOrderClient

data class ProfileClient(
    var uuid: String,
    val phone: String,
    val email: String,
    val addressList: List<AddressClient>?,
    val userOrderList: List<UserOrderClient>?
)
