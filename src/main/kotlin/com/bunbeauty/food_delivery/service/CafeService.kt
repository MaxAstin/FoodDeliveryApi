package com.bunbeauty.food_delivery.service

import com.bunbeauty.food_delivery.model.client.CafeClient
import com.bunbeauty.food_delivery.model.local.Cafe
import com.bunbeauty.food_delivery.model.mapper.CafeMapper
import com.bunbeauty.food_delivery.repository.CafeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CafeService {

    @Autowired
    lateinit var cafeRepository: CafeRepository

    @Autowired
    lateinit var cafeMapper: CafeMapper

    fun getCafes(): List<CafeClient> = cafeRepository.getAllBy().map { cafeMapper.toClientModel(it) }

    fun getCafeByCityUuid(cityUuid: String): List<CafeClient> =
        cafeRepository.getAllByCityUuid(cityUuid).map { cafeMapper.toClientModel(it) }
}