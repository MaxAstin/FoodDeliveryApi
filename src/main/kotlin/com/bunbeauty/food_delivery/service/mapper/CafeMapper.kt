package com.bunbeauty.food_delivery.service.mapper

import com.bunbeauty.food_delivery.error.NotFoundWithUuid
import com.bunbeauty.food_delivery.model.client.cafe.CafeClient
import com.bunbeauty.food_delivery.model.client.cafe.PostCafeClient
import com.bunbeauty.food_delivery.model.local.Cafe
import com.bunbeauty.food_delivery.model.local.City
import com.bunbeauty.food_delivery.repository.CityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CafeMapper {

    @Autowired
    lateinit var cityRepository: CityRepository

    fun toEntityModel(cafe: PostCafeClient): Cafe {
        return Cafe(
            uuid = cafe.uuid,
            fromTime = cafe.fromTime,
            toTime = cafe.toTime,
            phone = cafe.phone,
            latitude = cafe.latitude,
            longitude = cafe.longitude,
            visible = cafe.visible,
            city = cityRepository.getByUuid(cafe.cityUuid) ?: throw NotFoundWithUuid(City::class.simpleName!!),
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
            cityUuid = cafe.city.uuid,
            address = cafe.address,
        )
    }
}