package com.bunbeauty.food_delivery.service

import com.bunbeauty.food_delivery.model.client.cafe.CafeClient
import com.bunbeauty.food_delivery.model.client.cafe.PostCafeClient
import com.bunbeauty.food_delivery.service.mapper.CafeMapper
import com.bunbeauty.food_delivery.repository.CafeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class CafeService {

    @Autowired
    lateinit var cafeRepository: CafeRepository

    @Autowired
    lateinit var cafeMapper: CafeMapper

    fun insert(cafeClient: PostCafeClient): CafeClient {
        if (cafeClient.uuid.isEmpty())
            cafeClient.uuid = UUID.randomUUID().toString()

        return cafeMapper.toClientModel(cafeRepository.save(cafeMapper.toEntityModel(cafeClient)))
    }

    fun getCafes(): List<CafeClient> = cafeRepository.getAllBy().map { cafeMapper.toClientModel(it) }

    fun getCafeByCityUuid(cityUuid: String): List<CafeClient> =
        cafeRepository.getAllByCityUuid(cityUuid).map { cafeMapper.toClientModel(it) }
}