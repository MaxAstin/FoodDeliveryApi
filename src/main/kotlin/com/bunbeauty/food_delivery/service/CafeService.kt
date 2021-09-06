package com.bunbeauty.food_delivery.service

import com.bunbeauty.food_delivery.model.Cafe
import com.bunbeauty.food_delivery.repository.CafeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CafeService {

    @Autowired
    lateinit var cafeRepository: CafeRepository

    fun getCafes(): List<Cafe> = cafeRepository.getAllBy()

    fun getCafeByCity(city: String): List<Cafe> = cafeRepository.getAllByCity(city)
}