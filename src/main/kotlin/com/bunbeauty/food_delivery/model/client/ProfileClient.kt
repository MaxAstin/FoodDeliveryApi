package com.bunbeauty.food_delivery.model.client

data class ProfileClient(
    var uuid: String,
    val phone: String,
    val email: String,
    val addressList: List<AddressClient>?,
    val userOrderList: List<UserOrderClient>?
)
