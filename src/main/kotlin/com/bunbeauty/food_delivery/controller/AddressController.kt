package com.bunbeauty.food_delivery.controller

import com.bunbeauty.food_delivery.model.client.AddressClient
import com.bunbeauty.food_delivery.model.local.Address
import com.bunbeauty.food_delivery.service.AddressService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/address")
class AddressController {

    @Autowired
    lateinit var addressService: AddressService

    @PostMapping
    fun postAddress(@RequestBody address: AddressClient): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(addressService.insert(address))
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body("Error $ex")
        }
    }
}