package com.bunbeauty.food_delivery.controller

import com.bunbeauty.food_delivery.model.client.profile.PatchProfileClient
import com.bunbeauty.food_delivery.model.client.user_order.PatchUserOrderClient
import com.bunbeauty.food_delivery.model.client.user_order.PostUserOrderClient
import com.bunbeauty.food_delivery.model.client.user_order.UserOrderClient
import com.bunbeauty.food_delivery.model.toListWrapper
import com.bunbeauty.food_delivery.service.UserOrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user_order")
class UserOrderController {

    @Autowired
    lateinit var userOrderService: UserOrderService

    @PostMapping
    fun postUserOrder(@RequestBody order: PostUserOrderClient): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(userOrderService.insert(order))
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body("$ex")
        }
    }


    @PatchMapping
    fun patchUserOrder(
        @RequestParam uuid: String,
        @RequestBody order: PatchUserOrderClient
    ): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(userOrderService.update(uuid, order))
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body("$ex")
        }
    }

    @GetMapping
    fun getUserOrderByUuid(@RequestParam(required = false) uuid: String?): ResponseEntity<Any> {
        return try {
            if (uuid.isNullOrEmpty()) {
                ResponseEntity.ok(userOrderService.getUserOrderList().toListWrapper())
            } else {
                ResponseEntity.ok(userOrderService.getUserOrderListByProfileUuid(uuid).toListWrapper())
            }
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body("$ex")
        }
    }
}