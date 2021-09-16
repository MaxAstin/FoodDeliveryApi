package com.bunbeauty.food_delivery.controller

import com.bunbeauty.food_delivery.service.StreetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/street")
class StreetController {

    @Autowired
    lateinit var streetService: StreetService

    @GetMapping
    fun getCafeByCity(@RequestParam cityUuid: String): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(streetService.getByCity(cityUuid))
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body("Error")
        }
    }

}