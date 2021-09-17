package com.bunbeauty.food_delivery.controller

import com.bunbeauty.food_delivery.model.client.CityClient
import com.bunbeauty.food_delivery.model.toListWrapper
import com.bunbeauty.food_delivery.service.CityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/city")
class CityController {

    @Autowired
    lateinit var cityService: CityService

    @GetMapping
    fun getCities(): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(cityService.getAll().toListWrapper())
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body("Error")
        }
    }

    @PostMapping
    fun postCity(@RequestBody city: CityClient): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(cityService.insert(city))
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body("Error $ex")
        }
    }

}