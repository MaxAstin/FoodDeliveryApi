package com.bunbeauty.food_delivery.model.client.profile

import com.bunbeauty.food_delivery.model.client.address.PostAddressClient
import com.bunbeauty.food_delivery.model.client.user_order.PostUserOrderClient

data class PostProfileClient(
    var uuid: String,
    val phone: String,
    val email: String,
    val addressList: List<PostAddressClient>?,
    val userOrderList: List<PostUserOrderClient>?
)
