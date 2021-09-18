package com.bunbeauty.food_delivery.controller

import com.bunbeauty.food_delivery.model.client.CafeClient
import com.bunbeauty.food_delivery.model.client.StreetClient
import com.bunbeauty.food_delivery.model.toListWrapper
import com.bunbeauty.food_delivery.service.CafeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cafe")
class CafeController {

    @Autowired
    lateinit var cafeService: CafeService


    @PostMapping
    fun postCare(@RequestBody cafeClient: CafeClient): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(cafeService.insert(cafeClient))
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body("$ex")
        }
    }

    @GetMapping
    fun getCafeByCity(@RequestParam(required = false) cityUuid: String?): ResponseEntity<Any> {
        return try {
            if (cityUuid.isNullOrEmpty())
                ResponseEntity.ok(cafeService.getCafes().toListWrapper())
            else
                ResponseEntity.ok(cafeService.getCafeByCityUuid(cityUuid).toListWrapper())
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body("$ex")
        }
    }

}