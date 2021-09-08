package com.bunbeauty.food_delivery.controller

import com.bunbeauty.food_delivery.service.CafeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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

    @GetMapping
    fun getCafeByCity(@RequestParam city: String): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(cafeService.getCafeByCity(city))
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body("Error")
        }
    }

}