package com.bunbeauty.food_delivery.controller

import com.bunbeauty.food_delivery.model.client.ProductCodeClient
import com.bunbeauty.food_delivery.model.toListWrapper
import com.bunbeauty.food_delivery.service.ProductCodeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/product_code")
class ProductCodeController {

    @Autowired
    lateinit var productCodeService: ProductCodeService

    @PostMapping
    fun postProductCode(@RequestBody productCodeClient: ProductCodeClient): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(productCodeService.insert(productCode = productCodeClient))
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body("Error $ex")
        }
    }

    @GetMapping
    fun getProductCode(@RequestParam(required = false) uuid: String?): ResponseEntity<Any> {
        return try {
            if (uuid.isNullOrEmpty())
                ResponseEntity.ok(productCodeService.getAll().toListWrapper())
            else
                ResponseEntity.ok(productCodeService.getByUuid(uuid))
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body("$ex")
        }
    }
}