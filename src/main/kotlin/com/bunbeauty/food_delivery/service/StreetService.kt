package com.bunbeauty.food_delivery.service

import com.bunbeauty.food_delivery.model.client.StreetClient
import com.bunbeauty.food_delivery.repository.StreetRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StreetService {
    @Autowired
    lateinit var streetRepository: StreetRepository

    fun getByCity(cityUuid:String):List<StreetClient>{


        return emptyList()
    }
}