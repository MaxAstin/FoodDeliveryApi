package com.bunbeauty.food_delivery.controller

import com.bunbeauty.food_delivery.service.CafeService
import com.bunbeauty.food_delivery.service.MenuProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cafe")
class CafeController {

    @Autowired
    lateinit var cafeService: CafeService

    @GetMapping("/all")
    fun getCafe(): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(cafeService.getCafes())
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body("Error")
        }
    }

}