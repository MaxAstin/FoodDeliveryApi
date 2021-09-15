package com.bunbeauty.food_delivery.controller

import com.bunbeauty.food_delivery.model.client.UserOrderClient
import com.bunbeauty.food_delivery.model.local.UserOrder
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
    fun postUserOrder(@RequestBody order: UserOrderClient): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(userOrderService.insert(order))
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body("Error $ex")
        }
    }

    @GetMapping
    fun getUserOrderByUuid(@RequestParam uuid: String): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(userOrderService.getUserOrderListByProfileUuid(uuid))
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body("Error: $ex")
        }
    }
}