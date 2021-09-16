package com.bunbeauty.food_delivery.service

import com.bunbeauty.food_delivery.model.client.CityClient
import com.bunbeauty.food_delivery.model.mapper.CityMapper
import com.bunbeauty.food_delivery.repository.CityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class CityService {
    @Autowired
    lateinit var cityRepository: CityRepository

    @Autowired
    lateinit var cityMapper: CityMapper

    fun getAll(): List<CityClient> {
        return cityRepository.getAllBy().map { cityMapper.toClientModel(it) }
    }

    fun insert(cityClient: CityClient): CityClient {
        if (cityClient.uuid.isEmpty())
            cityClient.uuid = UUID.randomUUID().toString()

        cityRepository.save(cityMapper.toEntityModel(cityClient))
        return cityClient
    }

}