package com.bunbeauty.food_delivery.service.mapper

import com.bunbeauty.food_delivery.enums.OrderStatus
import com.bunbeauty.food_delivery.error.NotFoundWithUuid
import com.bunbeauty.food_delivery.model.client.user_order.PostUserOrderClient
import com.bunbeauty.food_delivery.model.client.user_order.UserOrderClient
import com.bunbeauty.food_delivery.model.local.Cafe
import com.bunbeauty.food_delivery.model.local.Profile
import com.bunbeauty.food_delivery.model.local.order.UserOrder
import com.bunbeauty.food_delivery.repository.CafeRepository
import com.bunbeauty.food_delivery.repository.ProfileRepository
import com.bunbeauty.food_delivery.service.util.CodeGenerator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserOrderMapper {

    @Autowired
    lateinit var profileRepository: ProfileRepository

    @Autowired
    lateinit var cafeRepository: CafeRepository

    @Autowired
    lateinit var orderCartProductMapper: OrderCartProductMapper

    @Autowired
    lateinit var codeGenerator: CodeGenerator

    fun toEntityModel(order: PostUserOrderClient): UserOrder {
        return UserOrder(
            uuid = order.uuid,
            time = Date().time,
            orderStatus = OrderStatus.NOT_ACCEPTED,
            isDelivery = order.isDelivery,
            code = if (order.code.isNullOrEmpty())
                codeGenerator.generateCode(Date().time, "АБВГДЕИКЛМНПРСТУФЦЧШЭЮЯ")
            else
                order.code,
            comment = order.comment,
            deferredTime = order.deferredTime,
            bonus = order.bonus,
            address = order.address,
            profile = profileRepository.getByUuid(order.profileUuid)
                ?: throw NotFoundWithUuid(Profile::class.simpleName!!),
            cafe = if (order.addressUuid.isNullOrEmpty()) {
                if (order.cafeUuid == null)
                    throw Exception("cafe UUID was null")

                cafeRepository.getByUuid(order.cafeUuid) ?: throw NotFoundWithUuid(Cafe::class.simpleName!!)
            } else {
                //delivery
                cafeRepository.findByAddressUuid(order.addressUuid)
                    ?: throw NotFoundWithUuid(Cafe::class.simpleName!!)
            },
            orderCartProducts = emptyList()
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
            profileUuid = order.profile.uuid,
            cafeUuid = order.cafe.uuid,
            orderProducts = order.orderCartProducts.map(orderCartProductMapper::toClientModel),
        )
    }

}