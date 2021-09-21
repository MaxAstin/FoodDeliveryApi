package com.bunbeauty.food_delivery.model.mapper

import com.bunbeauty.food_delivery.model.client.CityClient
import com.bunbeauty.food_delivery.model.local.City
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CityMapper {

    fun toEntityModel(city: CityClient): City {
        return City(
            uuid = city.uuid,
            name = city.name,
            timeOffset = city.offset,
            cafeList = emptyList()
        )
    }

    fun toClientModel(city: City): CityClient {
        return CityClient(
            uuid = city.uuid,
            name = city.name,
            offset = city.timeOffset,
        )
    }
}