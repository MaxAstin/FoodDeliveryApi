package com.bunbeauty.food_delivery.controller

import com.bunbeauty.food_delivery.service.MenuProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/menuProduct")
class MenuProductController {

    @Autowired
    lateinit var menuProductService: MenuProductService


    @RequestMapping("/")
    @ResponseBody
    fun home(): String {
        return "Hello World!"
    }

    @GetMapping("/all")
    fun getMenuProducts(): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(menuProductService.getMenuProducts())
        } catch (ex: Exception) {
            ResponseEntity.badRequest().body(ex.message)
        }
    }
}