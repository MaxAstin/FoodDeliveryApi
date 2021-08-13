package com.bunbeauty.food_delivery.service

import com.bunbeauty.food_delivery.model.Cafe
import com.bunbeauty.food_delivery.model.MenuProduct
import com.bunbeauty.food_delivery.repository.MenuProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CafeService {

    fun getCafes(): List<Cafe> = listOf(
        Cafe(
            uuid = "uuid1",
            fromTime = "10:00",
            toTime = "22:00",
            phone = "+7 (900) 111-14-21",
            latitude = 50.0,
            longitude = 39.0,
            visible = true,
            emptyList(),
            "address"
        )
    )
}