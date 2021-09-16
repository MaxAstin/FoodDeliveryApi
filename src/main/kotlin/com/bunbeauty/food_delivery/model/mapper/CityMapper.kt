package com.bunbeauty.food_delivery.model.mapper

import com.bunbeauty.food_delivery.model.client.CityClient
import com.bunbeauty.food_delivery.model.local.City
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CityMapper {

    @Autowired
    lateinit var cafeMapper: CafeMapper

    fun toEntityModel(city: CityClient): City {
        return City(
            uuid = city.uuid,
            name = city.name,
            cafeList = emptyList()
        )
    }

    fun toClientModel(city: City): CityClient {
        return CityClient(
            uuid = city.uuid,
            name = city.name,
            cafeList = city.cafeList.map { cafeMapper.toClientModel(it) }
        )
    }
}