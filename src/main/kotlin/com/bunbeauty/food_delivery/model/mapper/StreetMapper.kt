package com.bunbeauty.food_delivery.model.mapper

import com.bunbeauty.food_delivery.error.NotFoundWithUuid
import com.bunbeauty.food_delivery.model.client.address.AddressClient
import com.bunbeauty.food_delivery.model.client.street.PostStreetClient
import com.bunbeauty.food_delivery.model.client.street.StreetClient
import com.bunbeauty.food_delivery.model.local.Cafe
import com.bunbeauty.food_delivery.model.local.Street
import com.bunbeauty.food_delivery.repository.CafeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StreetMapper {

    @Autowired
    lateinit var cafeRepository: CafeRepository

    fun toEntityModel(street: PostStreetClient): Street {
        return Street(
            uuid = street.uuid,
            name = street.name,
            cafe = cafeRepository.getByUuid(street.cafeUuid)
                ?: throw NotFoundWithUuid(Cafe::class.simpleName!!),
            //могу ли удалить все привязанные
            addressList = emptyList(),
        )
    }

    fun toClientModel(street: Street): StreetClient {
        return StreetClient(
            uuid = street.uuid,
            name = street.name,
            cafeUuid = street.cafe.uuid,
            cityUuid = street.cafe.city.uuid,
        )
    }

}