package com.bunbeauty.food_delivery.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/order")
class OrderController {

    /*@PostMapping("/uuid")
    fun postOrder(): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(menuProductService.getMenuProducts())
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body("Error")
        }
    }*/

}