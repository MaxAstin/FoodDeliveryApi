package com.bunbeauty.food_delivery.model.mapper

import com.bunbeauty.food_delivery.model.client.StreetClient
import com.bunbeauty.food_delivery.model.local.Street
import org.springframework.stereotype.Service

@Service
class StreetMapper {

    fun toEntityModel(street: StreetClient): Street {
        return Street(
            uuid = street.uuid,
            name = street.name,
            cafe = street.cafe!!,
            addressList = street.addressList ?: emptyList(),
        )
    }

    fun toClientModel(street: Street): StreetClient {
        return StreetClient(
            uuid = street.uuid,
            name = street.name,
            cafe = street.cafe,
            cafeUuid = street.cafe.uuid,
            cityUuid = street.cafe.city.uuid,
            addressList = street.addressList,
        )
    }

}