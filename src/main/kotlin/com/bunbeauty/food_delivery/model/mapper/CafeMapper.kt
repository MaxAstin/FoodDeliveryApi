package com.bunbeauty.food_delivery.model.mapper

import com.bunbeauty.food_delivery.model.client.CafeClient
import com.bunbeauty.food_delivery.model.client.CityClient
import com.bunbeauty.food_delivery.model.local.Cafe
import com.bunbeauty.food_delivery.model.local.City
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CafeMapper {

    @Autowired
    lateinit var cityMapper: CityMapper

    fun toEntityModel(cafe: CafeClient): Cafe {
        return Cafe(
            uuid = cafe.uuid,
            fromTime = cafe.fromTime,
            toTime = cafe.toTime,
            phone = cafe.phone,
            latitude = cafe.latitude,
            longitude = cafe.longitude,
            visible = cafe.visible,
            city = cityMapper.toEntityModel(cafe.city!!),
            streets = emptyList(),
            userOrderList = emptyList(),
            address = cafe.address,
        )
    }

    fun toClientModel(cafe: Cafe): CafeClient {
        return CafeClient(
            uuid = cafe.uuid,
            fromTime = cafe.fromTime,
            toTime = cafe.toTime,
            phone = cafe.phone,
            latitude = cafe.latitude,
            longitude = cafe.longitude,
            visible = cafe.visible,
            city = cityMapper.toClientModel(cafe.city),
            cityUuid = cafe.city.uuid,
            address = cafe.address,
        )
    }
}