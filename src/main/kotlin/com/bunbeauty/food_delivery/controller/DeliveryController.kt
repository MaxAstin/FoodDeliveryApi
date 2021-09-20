package com.bunbeauty.food_delivery.controller

import com.bunbeauty.food_delivery.model.local.Delivery
import com.bunbeauty.food_delivery.service.DeliveryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/delivery")
class DeliveryController{

    @Autowired
    lateinit var deliverService: DeliveryService

    @PostMapping
    fun postDelivery(@RequestBody delivery: Delivery): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(deliverService.insert(delivery))
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body("Error")
        }
    }

    @GetMapping
    fun getDelivery(): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(deliverService.getDelivery())
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body("Error")
        }
    }

}