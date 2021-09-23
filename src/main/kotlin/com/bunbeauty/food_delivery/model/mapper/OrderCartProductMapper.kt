package com.bunbeauty.food_delivery.model.mapper

import com.bunbeauty.food_delivery.error.NotFoundWithUuid
import com.bunbeauty.food_delivery.model.client.order_cart_product.OrderCartProductClient
import com.bunbeauty.food_delivery.model.client.order_cart_product.PostOrderCartProductClient
import com.bunbeauty.food_delivery.model.local.MenuProduct
import com.bunbeauty.food_delivery.model.local.order.OrderCartProduct
import com.bunbeauty.food_delivery.model.local.order.UserOrder
import com.bunbeauty.food_delivery.repository.MenuProductRepository
import com.bunbeauty.food_delivery.repository.UserOrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class OrderCartProductMapper {

    @Autowired
    lateinit var menuProductMapper: MenuProductMapper

    @Autowired
    lateinit var menuProductRepository: MenuProductRepository

    @Autowired
    lateinit var userOrderRepository: UserOrderRepository

    /**
     * userOrder null because when map this,
     * userOrder is not in DB
     */
    fun toEntityModel(orderProduct: PostOrderCartProductClient, userOrderUuid: String): OrderCartProduct {
        return OrderCartProduct(
            uuid = if (orderProduct.uuid.isNullOrEmpty()) {
                UUID.randomUUID().toString()
            } else
                orderProduct.uuid,
            orderMenuProduct = menuProductMapper.toOrderMenuProductEntity(
                menuProductRepository.getByUuid(orderProduct.menuProductUuid)
                    ?: throw NotFoundWithUuid(MenuProduct::class.simpleName!!)
            ),
            count = orderProduct.count,
            userOrder = userOrderRepository.getByUuid(userOrderUuid)
                ?: throw NotFoundWithUuid(UserOrder::class.simpleName!!),
        )
    }

    fun toClientModel(orderCartProduct: OrderCartProduct): OrderCartProductClient {
        return OrderCartProductClient(
            uuid = orderCartProduct.uuid,
            name = orderCartProduct.orderMenuProduct.name,
            cost = orderCartProduct.orderMenuProduct.cost,
            discountCost = orderCartProduct.orderMenuProduct.discountCost,
            weight = orderCartProduct.orderMenuProduct.weight,
            description = orderCartProduct.orderMenuProduct.description,
            comboDescription = orderCartProduct.orderMenuProduct.comboDescription,
            barcode = orderCartProduct.orderMenuProduct.barcode,
            photoLink = orderCartProduct.orderMenuProduct.photoLink,
            orderUuid = orderCartProduct.userOrder.uuid,
            count = orderCartProduct.count,
        )
    }

}