package com.bunbeauty.food_delivery.controller

import com.bunbeauty.food_delivery.model.UserOrder
import com.bunbeauty.food_delivery.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user_order")
class OrderController {

    @Autowired
    lateinit var orderService: OrderService

    @PostMapping
    fun postUserOrder(@RequestBody order: UserOrder): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(orderService.insert(order))
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body("Error $ex")
        }
    }

}