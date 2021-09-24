package com.bunbeauty.food_delivery.service

import com.bunbeauty.food_delivery.model.client.street.PostStreetClient
import com.bunbeauty.food_delivery.model.client.street.StreetClient
import com.bunbeauty.food_delivery.service.mapper.StreetMapper
import com.bunbeauty.food_delivery.repository.StreetRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class StreetService {
    @Autowired
    lateinit var streetRepository: StreetRepository

    @Autowired
    lateinit var streetMapper: StreetMapper

    fun insert(streetClient: PostStreetClient): StreetClient {
        if (streetClient.uuid.isEmpty())
            streetClient.uuid = UUID.randomUUID().toString()

        return streetMapper.toClientModel(streetRepository.save(streetMapper.toEntityModel(streetClient)))
    }

    fun getByCity(cityUuid: String): List<StreetClient> {
        return streetRepository.getByCityUuid(cityUuid)
            .map { streetMapper.toClientModel(it) }
    }

    fun getAll(): List<StreetClient> {
        return streetRepository.getBy().map { streetMapper.toClientModel(it) }
    }
}