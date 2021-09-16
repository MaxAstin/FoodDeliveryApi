package com.bunbeauty.food_delivery.model.mapper

import com.bunbeauty.food_delivery.model.client.CafeClient
import com.bunbeauty.food_delivery.model.client.CityClient
import com.bunbeauty.food_delivery.model.local.Cafe
import com.bunbeauty.food_delivery.model.local.City
import org.springframework.stereotype.Service

@Service
class CafeMapper {

   /* fun toEntityModel(cafe: CafeClient): Cafe {
        return Cafe(
            uuid = cafe.uuid,
            fromTime = cafe.fromTime,
            toTime = cafe.toTime,
            phone = cafe.phone,
            latitude = cafe.latitude,
            longitude = cafe.longitude,
            visible = cafe.visible,
            city = cafe.,
            address = cafe.address,
        )
    }*/

    fun toClientModel(cafe: Cafe): CafeClient {
        return CafeClient(
            uuid = cafe.uuid,
            fromTime = cafe.fromTime,
            toTime = cafe.toTime,
            phone = cafe.phone,
            latitude = cafe.latitude,
            longitude = cafe.longitude,
            visible = cafe.visible,
            cityUuid = cafe.city.uuid,
            address = cafe.address,
        )
    }
}