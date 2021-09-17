package com.bunbeauty.food_delivery.service

import com.bunbeauty.food_delivery.error.NotFoundWithUuid
import com.bunbeauty.food_delivery.model.client.StreetClient
import com.bunbeauty.food_delivery.model.local.Cafe
import com.bunbeauty.food_delivery.model.local.Street
import com.bunbeauty.food_delivery.model.mapper.StreetMapper
import com.bunbeauty.food_delivery.repository.CafeRepository
import com.bunbeauty.food_delivery.repository.StreetRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class StreetService {
    @Autowired
    lateinit var streetRepository: StreetRepository

    @Autowired
    lateinit var cafeRepository: CafeRepository

    @Autowired
    lateinit var streetMapper: StreetMapper


    fun insert(streetClient: StreetClient): StreetClient {
        if (streetClient.uuid.isEmpty())
            streetClient.uuid = UUID.randomUUID().toString()

        streetClient.cafe = cafeRepository.getByUuid(streetClient.cafeUuid)
            ?: throw NotFoundWithUuid(Cafe::class.simpleName!!)

        streetRepository.save(streetMapper.toEntityModel(streetClient))

        return streetClient
    }

    fun getByCity(cityUuid: String): List<StreetClient> {
        return streetRepository.getByCityUuid(cityUuid).map { streetMapper.toClientModel(it) }
    }

    fun getAll(): List<StreetClient> {
        return streetRepository.getBy().map { streetMapper.toClientModel(it) }
    }
}