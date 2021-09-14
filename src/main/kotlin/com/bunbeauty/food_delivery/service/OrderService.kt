package com.bunbeauty.food_delivery.service

import com.bunbeauty.food_delivery.model.UserOrder
import com.bunbeauty.food_delivery.repository.AddressRepository
import com.bunbeauty.food_delivery.repository.CafeRepository
import com.bunbeauty.food_delivery.repository.ProfileRepository
import com.bunbeauty.food_delivery.repository.UserOrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class OrderService {

    @Autowired
    lateinit var userOrderRepository: UserOrderRepository

    @Autowired
    lateinit var profileRepository: ProfileRepository

    @Autowired
    lateinit var cafeRepository: CafeRepository

    fun insert(order: UserOrder): UserOrder {
        if (order.uuid.isEmpty())
            order.uuid = UUID.randomUUID().toString()

        order.profile = profileRepository.getByUuid(order.profileUuid)
            ?: throw Exception(getErrorMessage("profile"))

        if (order.addressUuid.isNullOrEmpty()) {
            order.cafe =
                cafeRepository.getByUuid(order.cafeUuid ?: "")
        } else {
            //delivery
            order.cafe = cafeRepository.findByAddressUuid(order.addressUuid)
                ?: throw Exception(getErrorMessage("cafe by address"))
        }

        userOrderRepository.save(order)
        return order
    }

    fun getErrorMessage(entity: String): String {
        return "Not found $entity with UUID"
    }
}