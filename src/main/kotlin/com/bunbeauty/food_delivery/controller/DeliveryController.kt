package com.bunbeauty.food_delivery.controller

import com.bunbeauty.food_delivery.service.DeliveryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/delivery")
class DeliveryController{

    @Autowired
    lateinit var deliverService: DeliveryService

    @GetMapping("/")
    fun getCafe(): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(deliverService.getDelivery())
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body("Error")
        }
    }

}