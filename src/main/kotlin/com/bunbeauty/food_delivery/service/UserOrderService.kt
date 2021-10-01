package com.bunbeauty.food_delivery.service

import com.bunbeauty.food_delivery.error.NotFoundWithUuid
import com.bunbeauty.food_delivery.model.client.user_order.PatchUserOrderClient
import com.bunbeauty.food_delivery.model.client.user_order.PostUserOrderClient
import com.bunbeauty.food_delivery.model.client.user_order.UserOrderClient
import com.bunbeauty.food_delivery.model.local.order.UserOrder
import com.bunbeauty.food_delivery.service.mapper.OrderCartProductMapper
import com.bunbeauty.food_delivery.service.mapper.UserOrderMapper
import com.bunbeauty.food_delivery.repository.OrderProductRepository
import com.bunbeauty.food_delivery.repository.UserOrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.simp.SimpMessagingTemplate
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

    @Autowired
    lateinit var simpMessagingTemplate: SimpMessagingTemplate

    fun insert(order: PostUserOrderClient): UserOrderClient {
        if (order.uuid.isEmpty())
            order.uuid = UUID.randomUUID().toString()

        //first insert userOrder
        val userOrder = userOrderRepository.save(userOrderMapper.toEntityModel(order))

        //second insert OrderProducts
        order.orderProducts?.let { orderProductList ->
            userOrder.orderCartProducts =
                    orderProductRepository.saveAll(orderProductList.map {
                        orderCartProductMapper.toEntityModel(
                                it,
                                order.uuid
                        )
                    }).toList()
        }

        simpMessagingTemplate.convertAndSend("/topic/orders", userOrderMapper.toClientModel(userOrder))
        Thread.sleep(1000)
        simpMessagingTemplate.convertAndSend("/order", userOrderMapper.toClientModel(userOrder))

        return userOrderMapper.toClientModel(userOrder)
    }

    fun update(userOrderUuid: String, order: PatchUserOrderClient): UserOrderClient {
        if (userOrderUuid.isEmpty())
            throw Exception("Uuid was empty")

        val userOrderFromLocal =
                userOrderRepository.getByUuid(userOrderUuid) ?: throw NotFoundWithUuid(UserOrder::class.simpleName!!)

        val updatedUserOrder = UserOrder(
                uuid = userOrderUuid,
                time = userOrderFromLocal.time,
                orderStatus = order.orderStatus ?: userOrderFromLocal.orderStatus,
                isDelivery = userOrderFromLocal.isDelivery,
                code = userOrderFromLocal.code,
                address = userOrderFromLocal.address,
                comment = userOrderFromLocal.comment,
                deferredTime = userOrderFromLocal.deferredTime,
                bonus = userOrderFromLocal.bonus,
                profile = userOrderFromLocal.profile,
                cafe = userOrderFromLocal.cafe,
                orderCartProducts = userOrderFromLocal.orderCartProducts,
        )

        userOrderRepository.save(updatedUserOrder)
        return userOrderMapper.toClientModel(updatedUserOrder)
    }

    fun getUserOrderListByProfileUuid(uuid: String): List<UserOrderClient> {
        val list = userOrderRepository.findByProfileUuid(uuid).map { userOrderMapper.toClientModel(it) }
        simpMessagingTemplate.convertAndSend("/topic/orders", list.first())

        return list
    }

    fun getUserOrderList(): List<UserOrderClient> {
        return userOrderRepository.getAllBy().map(userOrderMapper::toClientModel)
    }

}