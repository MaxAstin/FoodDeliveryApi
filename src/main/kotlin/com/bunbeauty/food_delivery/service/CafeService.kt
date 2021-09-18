package com.bunbeauty.food_delivery.service

import com.bunbeauty.food_delivery.error.NotFoundWithUuid
import com.bunbeauty.food_delivery.model.client.CafeClient
import com.bunbeauty.food_delivery.model.client.StreetClient
import com.bunbeauty.food_delivery.model.local.Cafe
import com.bunbeauty.food_delivery.model.local.City
import com.bunbeauty.food_delivery.model.mapper.CafeMapper
import com.bunbeauty.food_delivery.model.mapper.CityMapper
import com.bunbeauty.food_delivery.repository.CafeRepository
import com.bunbeauty.food_delivery.repository.CityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class CafeService {

    @Autowired
    lateinit var cafeRepository: CafeRepository

    @Autowired
    lateinit var cafeMapper: CafeMapper

    @Autowired
    lateinit var cityMapper: CityMapper

    @Autowired
    lateinit var cityRepository: CityRepository

    fun insert(cafeClient: CafeClient): CafeClient {
        if (cafeClient.uuid.isEmpty())
            cafeClient.uuid = UUID.randomUUID().toString()

        cafeClient.city = cityMapper.toClientModel(
            cityRepository.getByUuid(cafeClient.cityUuid) ?: throw NotFoundWithUuid(City::class.simpleName!!)
        )

        cafeRepository.save(cafeMapper.toEntityModel(cafeClient))

        return cafeClient
    }

    fun getCafes(): List<CafeClient> = cafeRepository.getAllBy().map { cafeMapper.toClientModel(it) }

    fun getCafeByCityUuid(cityUuid: String): List<CafeClient> =
        cafeRepository.getAllByCityUuid(cityUuid).map { cafeMapper.toClientModel(it) }
}