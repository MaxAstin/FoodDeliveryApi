package com.bunbeauty.food_delivery.service

import com.bunbeauty.food_delivery.model.client.user_order.PostUserOrderClient
import com.bunbeauty.food_delivery.model.client.user_order.UserOrderClient
import com.bunbeauty.food_delivery.model.mapper.UserOrderMapper
import com.bunbeauty.food_delivery.repository.UserOrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserOrderService {

    @Autowired
    lateinit var userOrderRepository: UserOrderRepository

    @Autowired
    lateinit var userOrderMapper: UserOrderMapper

    fun insert(order: PostUserOrderClient): UserOrderClient {
        if (order.uuid.isEmpty())
            order.uuid = UUID.randomUUID().toString()

        return userOrderMapper.toClientModel(
            userOrderRepository.save(
                userOrderMapper.toEntityModel(order = order)
            )
        )
    }

    fun getUserOrderListByProfileUuid(uuid: String): List<UserOrderClient> {
        return userOrderRepository.findByProfileUuid(uuid).map { userOrderMapper.toClientModel(it) }
    }

    fun getUserOrderList(): List<UserOrderClient> {
        return userOrderRepository.getAllBy().map(userOrderMapper::toClientModel)
    }

}