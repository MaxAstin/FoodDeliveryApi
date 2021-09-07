package com.bunbeauty.food_delivery.controller

import com.bunbeauty.food_delivery.model.client.MenuProductClient
import com.bunbeauty.food_delivery.model.local.Delivery
import com.bunbeauty.food_delivery.model.toListWrapper
import com.bunbeauty.food_delivery.service.MenuProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/menuProduct")
class MenuProductController {

    @Autowired
    lateinit var menuProductService: MenuProductService

    @PostMapping
    fun postMenuProduct(@RequestBody menuProductClient: MenuProductClient): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(menuProductService.insert(menuProductClient))
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body(ex.message)
        }
    }

    @GetMapping
    fun getMenuProducts(): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(menuProductService.getMenuProducts().toListWrapper())
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body(ex.message)
        }
    }
}