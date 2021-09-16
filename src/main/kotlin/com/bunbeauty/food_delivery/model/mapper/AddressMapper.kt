package com.bunbeauty.food_delivery.model.mapper

import com.bunbeauty.food_delivery.model.client.AddressClient
import com.bunbeauty.food_delivery.model.client.UserOrderClient
import com.bunbeauty.food_delivery.model.local.Address
import com.bunbeauty.food_delivery.model.local.UserOrder
import org.springframework.stereotype.Service

@Service
class AddressMapper {

    fun toEntityModel(address: AddressClient): Address {
        return Address(
            uuid = address.uuid,
            street = address.street!!,
            house = address.house,
            flat = address.flat,
            entrance = address.entrance,
            comment = address.comment,
            floor = address.floor,
            profile = address.profile!!,
        )
    }

    fun toClientModel(address: Address): AddressClient {
        return AddressClient(
            uuid = address.uuid,
            street = address.street,
            streetUuid = address.profile.uuid,
            house = address.house,
            flat = address.flat,
            entrance = address.entrance,
            comment = address.comment,
            floor = address.floor,
            profile = address.profile,
            profileUuid = address.profile.uuid
        )
    }

}