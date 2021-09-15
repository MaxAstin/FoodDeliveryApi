package com.bunbeauty.food_delivery.model.mapper

import com.bunbeauty.food_delivery.model.client.UserOrderClient
import com.bunbeauty.food_delivery.model.local.UserOrder
import org.springframework.stereotype.Service

@Service
class UserOrderMapper {

    fun toEntityModel(order: UserOrderClient): UserOrder {
        return UserOrder(
            uuid = order.uuid,
            time = order.time,
            orderStatus = order.orderStatus,
            isDelivery = order.isDelivery,
            code = order.code,
            comment = order.comment,
            deferredTime = order.deferredTime,
            bonus = order.bonus,
            address = order.address,
            profile = order.profile!!,
            cafe = order.cafe!!,
            orderProducts = order.orderProducts ?: emptyList(),
        )
    }

    fun toClientModel(order: UserOrder): UserOrderClient {
        return UserOrderClient(
            uuid = order.uuid,
            time = order.time,
            orderStatus = order.orderStatus,
            isDelivery = order.isDelivery,
            code = order.code,
            comment = order.comment,
            deferredTime = order.deferredTime,
            bonus = order.bonus,
            address = order.address,
            addressUuid = null,
            profile = order.profile,
            profileUuid = order.profile?.uuid ?: "",
            cafe = order.cafe,
            cafeUuid = order.cafe?.uuid ?: "",
            orderProducts = order.orderProducts,
        )
    }

}