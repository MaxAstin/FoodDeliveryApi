package com.bunbeauty.food_delivery.controller

import com.bunbeauty.food_delivery.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/order")
class OrderController {

    @Autowired
    lateinit var orderService: OrderService

  /*  @PostMapping("/{name}")
    fun postOrder(@ModelAttribute order: Order): String {
        orderService.insert(order)
        return "Success"
    }*/

}