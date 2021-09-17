package com.bunbeauty.food_delivery.controller

import com.bunbeauty.food_delivery.model.client.AddressClient
import com.bunbeauty.food_delivery.model.client.StreetClient
import com.bunbeauty.food_delivery.model.toListWrapper
import com.bunbeauty.food_delivery.service.StreetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/street")
class StreetController {

    @Autowired
    lateinit var streetService: StreetService

    @PostMapping
    fun postStreet(@RequestBody streetClient: StreetClient): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(streetService.insert(streetClient))
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body("$ex")
        }
    }

    @GetMapping
    fun getStreetListByCity(@RequestParam(required = false) cityUuid: String?): ResponseEntity<Any> {
        return try {
            if (cityUuid.isNullOrEmpty())
                ResponseEntity.ok(streetService.getAll().toListWrapper())
            else
                ResponseEntity.ok(streetService.getByCity(cityUuid).toListWrapper())
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body("$ex")
        }
    }

}