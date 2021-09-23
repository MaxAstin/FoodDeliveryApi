package com.bunbeauty.food_delivery.service

import com.bunbeauty.food_delivery.model.client.user_order.PostUserOrderClient
import com.bunbeauty.food_delivery.model.client.user_order.UserOrderClient
import com.bunbeauty.food_delivery.model.mapper.OrderCartProductMapper
import com.bunbeauty.food_delivery.model.mapper.UserOrderMapper
import com.bunbeauty.food_delivery.repository.OrderProductRepository
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

    @Autowired
    lateinit var orderProductRepository: OrderProductRepository

    @Autowired
    lateinit var orderCartProductMapper: OrderCartProductMapper

    fun insert(order: PostUserOrderClient): UserOrderClient {
        if (order.uuid.isEmpty())
            order.uuid = UUID.randomUUID().toString()

        //first insert userOrder
        val userOrderClient = userOrderRepository.save(userOrderMapper.toEntityModel(order))

        //second insert OrderProducts
        order.orderProducts?.let { orderProductList ->
            userOrderClient.orderCartProducts =
                orderProductRepository.saveAll(orderProductList.map {
                    orderCartProductMapper.toEntityModel(
                        it,
                        order.uuid
                    )
                }).toList()
        }
        return userOrderMapper.toClientModel(userOrderClient)
    }

    fun getUserOrderListByProfileUuid(uuid: String): List<UserOrderClient> {
        return userOrderRepository.findByProfileUuid(uuid).map { userOrderMapper.toClientModel(it) }
    }

    fun getUserOrderList(): List<UserOrderClient> {
        return userOrderRepository.getAllBy().map(userOrderMapper::toClientModel)
    }

}