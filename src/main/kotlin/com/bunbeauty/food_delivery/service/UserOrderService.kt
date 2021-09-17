package com.bunbeauty.food_delivery.service

import com.bunbeauty.food_delivery.error.NotFoundWithUuid
import com.bunbeauty.food_delivery.model.client.UserOrderClient
import com.bunbeauty.food_delivery.model.local.Cafe
import com.bunbeauty.food_delivery.model.local.Profile
import com.bunbeauty.food_delivery.model.local.Street
import com.bunbeauty.food_delivery.model.local.UserOrder
import com.bunbeauty.food_delivery.model.mapper.UserOrderMapper
import com.bunbeauty.food_delivery.repository.CafeRepository
import com.bunbeauty.food_delivery.repository.ProfileRepository
import com.bunbeauty.food_delivery.repository.UserOrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserOrderService {

    @Autowired
    lateinit var userOrderRepository: UserOrderRepository

    @Autowired
    lateinit var profileRepository: ProfileRepository

    @Autowired
    lateinit var cafeRepository: CafeRepository

    @Autowired
    lateinit var userOrderMapper: UserOrderMapper

    fun insert(order: UserOrderClient): UserOrderClient {
        if (order.uuid.isEmpty())
            order.uuid = UUID.randomUUID().toString()

        order.profile = profileRepository.getByUuid(order.profileUuid)
            ?: throw NotFoundWithUuid(Profile::class.simpleName!!)

        if (order.addressUuid.isNullOrEmpty()) {
            if (order.cafeUuid == null)
                throw Exception("cafe UUID was null")

            order.cafe =
                cafeRepository.getByUuid(order.cafeUuid)
        } else {
            //delivery
            order.cafe = cafeRepository.findByAddressUuid(order.addressUuid)
                ?: throw NotFoundWithUuid(Cafe::class.simpleName!!)        }

        userOrderRepository.save(userOrderMapper.toEntityModel(order))
        return order
    }

    fun getUserOrderListByProfileUuid(uuid: String): List<UserOrderClient> {
        return userOrderRepository.findByProfileUuid(uuid).map { userOrderMapper.toClientModel(it) }
    }

}